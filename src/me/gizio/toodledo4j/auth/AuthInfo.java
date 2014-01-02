package me.gizio.toodledo4j.auth;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import me.gizio.toodledo4j.others.MyUrl;
import me.gizio.toodledo4j.others.MyUtils;
import net.arnx.jsonic.JSON;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.joda.time.DateTime;

public class AuthInfo {

	private static AuthInfo instance = new AuthInfo();

	private AuthInfo() {
	}

	public static AuthInfo getInstance() {
		return instance;
	}

	private String email;
	private String userId;
	private String password;
	private String lookupSig;
	private String appId;
	private String authSig;
	private String appToken;
	private String sessionToken;
	private String key;
	private DateTime date;

	public boolean initialize(final String email, final String password,
			final String appId, final String appToken) {

		this.email = null;
		this.userId = null;
		this.password = null;
		this.lookupSig = null;
		this.appId = null;
		this.authSig = null;
		this.appToken = null;
		this.sessionToken = null;
		this.key = null;
		this.date = null;

		this.email = email;
		this.appId = appId;
		this.password = password;
		this.appToken = appToken;
		lookupSig = getLookupSig(email, appToken);
		this.userId = retrieveUserId(email, password, appId, lookupSig);
		authSig = generateAuthSig(userId, appToken);
		sessionToken = retrieveSessionToken(userId, appId, authSig);
		key = generateKey(appToken, password, sessionToken);
		date = new DateTime();

		if (this.email.equals(null)) {
			return false;
		} else if (this.userId.equals(null)) {
			return false;
		} else if (this.password.equals(null)) {
			return false;
		} else if (this.lookupSig.equals(null)) {
			return false;
		} else if (this.appId.equals(null)) {
			return false;
		} else if (this.authSig.equals(null)) {
			return false;
		} else if (this.appToken.equals(null)) {
			return false;
		} else if (this.sessionToken.equals(null)) {
			return false;
		} else if (this.key.equals(null)) {
			return false;
		} else {
			return true;
		}
	}

	public String getEmail() {
		return email;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppToken() {
		return appToken;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public String getLookupSig() {
		return lookupSig;
	}

	public String getAuthSig() {
		return authSig;
	}

	public String getKey() {
		return key;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public DateTime getDate() {
		return date;
	}

	private String retrieveUserId(String email, String password, String appId,
			String lookupSig) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(MyUrl.getAccountUrl()
				+ "/lookup.php?email=" + email + ";appid=" + appId + ";pass="
				+ password + ";sig=" + lookupSig);
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(httpPost);
			ResponseHandler<String> handler = new BasicResponseHandler();
			String body = handler.handleResponse(response);

			Map tokenMap = (Map) JSON.decode(body);
			return (String) tokenMap.get("userid");
		} catch (IOException e) {
			e.printStackTrace();
		}
		MyUtils.log("No User.");
		return null;
	}

	private String getLookupSig(String email, String appToken) {
		return md5(email + appToken);
	}

	private String generateKey(String appToken, String password,
			String sessionToken) {
		return md5(md5(password) + appToken + sessionToken);
	}

	private String retrieveSessionToken(String userId, String appId,
			String authSig) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(MyUrl.getAccountUrl()
				+ "/token.php?userid=" + userId + ";appid=" + appId + ";sig="
				+ authSig);
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(httpPost);
			ResponseHandler<String> handler = new BasicResponseHandler();
			String body = handler.handleResponse(response);

			Map tokenMap = (Map) JSON.decode(body);
			return (String) tokenMap.get("token");
		} catch (IOException e) {
			e.printStackTrace();
		}
		MyUtils.log("No Session Token.");
		return null;
	}

	private String generateAuthSig(String userId, String appToken) {
		return md5(userId + appToken);
	}

	private String md5(String source) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");

			byte[] data = source.getBytes();
			md.update(data);

			byte[] digest = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digest.length; i++) {
				int b = (0xFF & digest[i]);
				if (b < 16)
					sb.append("0");
				sb.append(Integer.toHexString(b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}
}
