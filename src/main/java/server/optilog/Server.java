package server.optilog;

import server.optilog.log.Logger;
import server.optilog.log.console.Console;
import server.optilog.setting.SettingFiles;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Server {
	public static boolean isServerRun = true;
	
	public static void startServer() {
		try {
			DatagramSocket ds = new DatagramSocket(SettingFiles.socketNumber);
			System.out.println("OptilogServer Note: OptilogServer Start Successful!");
			
			do {
				byte[] buffer = new byte[1024];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				ds.receive(packet);
				String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
				s = "(Server)" + s;
				
				String printLvl = s.substring(s.length() - 4);
				printLvl = printLvl.toLowerCase();
				if ("info".equals(printLvl)) {
					s = s.substring(0, s.length() - 4);
					if (SettingFiles.sfinfo) {
						System.out.print(s);
					}
					
					if (Console.print && SettingFiles.cinfo) {
						try {
							Logger.INFOO.write(s.getBytes(StandardCharsets.UTF_8));
							Logger.INFOO.flush();
						} catch (RuntimeException | IOException var9) {
							System.out.println("OptilogServer Note:Java throws Exception when log is written");
							var9.printStackTrace();
						}
					}
				}
				
				if ("rror".equals(printLvl)) {
					s = s.substring(0, s.length() - 5);
					if (SettingFiles.sfinfo) {
						System.out.print(s);
					}
					
					if (Console.print && SettingFiles.cerror) {
						try {
							Logger.INFOO.write(s.getBytes(StandardCharsets.UTF_8));
							Logger.INFOO.flush();
						} catch (RuntimeException | IOException var8) {
							System.out.println("OptilogServer Note:Java throws Exception when log is written");
							var8.printStackTrace();
						}
					}
				}
				
				if ("ning".equals(printLvl)) {
					s = s.substring(0, s.length() - 7);
					if (SettingFiles.sfwarn) {
						System.out.print(s);
					}
					
					if (Console.print && SettingFiles.cwarn) {
						try {
							Logger.INFOO.write(s.getBytes(StandardCharsets.UTF_8));
							Logger.INFOO.flush();
						} catch (RuntimeException | IOException var7) {
							System.out.println("OptilogServer Note:Java throws Exception when log is written");
							var7.printStackTrace();
						}
					}
				}
				
				if ("ebug".equals(printLvl)) {
					s = s.substring(0, s.length() - 5);
					if (SettingFiles.sfdebug) {
						System.out.print(s);
					}
					
					if (Console.print && SettingFiles.cdebug) {
						try {
							Logger.INFOO.write(s.getBytes(StandardCharsets.UTF_8));
							Logger.INFOO.flush();
						} catch (RuntimeException | IOException var6) {
							System.out.println("OptilogServer Note:Java throws Exception when log is written");
							var6.printStackTrace();
						}
					}
				}
				
				if ("atal".equals(printLvl)) {
					s = s.substring(0, s.length() - 5);
					if (SettingFiles.sffatal) {
						System.out.print(s);
					}
					
					if (Console.print && SettingFiles.cfatal) {
						try {
							Logger.INFOO.write(s.getBytes(StandardCharsets.UTF_8));
							Logger.INFOO.flush();
						} catch (RuntimeException | IOException var6) {
							System.out.println("OptilogServer Note:Java throws Exception when log is written");
							var6.printStackTrace();
						}
					}
				}
				
			} while (isServerRun);
		} catch (IOException io) {
			System.out.println("OptilogServer Note: Failed to start server");
			io.printStackTrace();
		}
	}
}