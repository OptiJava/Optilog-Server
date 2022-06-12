package com.optilog;

import server.optilog.log.Log;

public class OptilogServerTest {
	public static void main(String[] args) {
		Log log = Log.initLog("D:\\Program\\Project\\resources\\app\\Git\\Projects\\Optilog-Server\\src\\test\\resources\\Settings.json");
		log.command("%StartServer");
		log.debug("Server");
	}
}
