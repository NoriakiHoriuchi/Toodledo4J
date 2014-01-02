package me.gizio.toodledo4j.others;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyUtils {
	public static void log(String message) {
		String configFile = "conf/toodledo4j.conf";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(configFile));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		String debug = prop.getProperty("debug");
		if (debug.equals("true")) {
			System.out.println(message);
		}
	}
}