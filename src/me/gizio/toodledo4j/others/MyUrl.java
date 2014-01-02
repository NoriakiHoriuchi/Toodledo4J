package me.gizio.toodledo4j.others;

public class MyUrl {
	private static final String BASE_URL = "http://api.toodledo.com/2";
	private static final String ACCOUNT_URL = BASE_URL + "/account";

	public static String getBaseUrl() {
		return BASE_URL;
	}

	public static String getAccountUrl() {
		return ACCOUNT_URL;
	}

}
