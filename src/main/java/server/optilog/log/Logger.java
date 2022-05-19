package server.optilog.log;

import server.optilog.Server;
import server.optilog.log.console.Console;
import server.optilog.setting.SettingFiles;
import server.optilog.util.exception.GsonNotFoundException;
import server.optilog.util.exception.InvalidCommandException;
import server.optilog.util.exception.OptilogException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static final String time = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss").format(LocalDateTime.now());
    public static volatile OutputStream INFOO;
    
    public Logger() {
    }
    
    static String getLocalThread() {
        return Thread.currentThread().getName();
    }
    
    static void initlog(String settingFilePath) {
        if (settingFilePath == null) {
            throw new OptilogException("Can't init log because setting file path is null!", new NullPointerException("Setting file path is null!"));
        } else {
            try {
                Class.forName("com.google.gson.Gson");
            } catch (ClassNotFoundException var3) {
                if (!settingFilePath.isBlank()) {
                    System.out.println("Can't find Gson in classpath");
                    throw new GsonNotFoundException("Can't found Gson in classpath", new ClassNotFoundException("Class:com.google.gson.Gson not found"));
                }
            }
            
            try {
                SettingFiles.check(settingFilePath);
                Console.file();
            } catch (RuntimeException | IOException var2) {
                var2.printStackTrace();
                System.out.println("Optilog Note:An Exception was thrown when Optilog init logger");
            }
            
        }
    }
    
    static Optilog reInitLog() {
        return new Optilog();
    }
    
    void logInfo(String message) {
        if (SettingFiles.sfinfo) {
            this.loggerPrint("info", message);
        }
        
        if (Console.print && SettingFiles.cinfo) {
            this.loggerConsole("info", message);
        }
    }
    
    void logError(String message) {
        if (SettingFiles.sferror) {
            this.loggerPrint("Error", message);
        }
        
        if (Console.print && SettingFiles.cerror) {
            this.loggerConsole("Error", message);
        }
    }
    
    void logWarn(String message) {
        if (SettingFiles.sfwarn) {
            this.loggerPrint("Warn", message);
        }
        
        if (Console.print && SettingFiles.cwarn) {
            this.loggerConsole("Warn", message);
        }
    }
    
    void logDebug(String message) {
        if (SettingFiles.sfdebug) {
            this.loggerPrint("debug", message);
        }
        
        if (Console.print && SettingFiles.cdebug) {
            this.loggerConsole("debug", message);
        }
        
    }
    
    static void logCommand(String command) {
        switch (command) {
            case "%StartServer":
                Server.startServer();
                break;
            default:
                try {
                    throw new InvalidCommandException("Invalid Command '" + command + "' ");
                } catch (RuntimeException var4) {
                    var4.printStackTrace();
                    System.out.println("Optilog Note:Invalid command ' " + command + " '");
                }
        }
    }
    
    public void loggerPrint(String level, String message) {
        message = this.searchMessage(message);
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        synchronized(this) {
            System.out.print("[" + time + "][" + arr[4].getClassName() + " " + arr[4].getMethodName() + "(" + arr[4].getFileName() + ":" + arr[4].getLineNumber() + ")/" + getLocalThread() + "] " + level + ":" + message + "\n");
        }
    }
    
    public void loggerConsole(String level, String message) {
        message = this.searchMessage(message);
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        
        try {
            String writeo = "[" + time + "][" + arr[4].getClassName() + " " + arr[4].getMethodName() + "(" + arr[4].getFileName() + ":" + arr[4].getLineNumber() + ")/" + getLocalThread() + "] " + level + ":" + message + "\n";
            INFOO.write(writeo.getBytes(StandardCharsets.UTF_8));
            INFOO.flush();
        } catch (RuntimeException | IOException var5) {
            var5.printStackTrace();
            System.out.println("Optilog Note:Java throws Exception when log is written");
        }
        
    }
    
    private String searchMessage(String previousMessage) {
        previousMessage = previousMessage.replaceAll("%os.name", " " + System.getProperty("os.name") + " ");
        previousMessage = previousMessage.replaceAll("%java.version", " " + System.getProperty("java.version") + " ");
        previousMessage = previousMessage.replaceAll("%java.vendor", " " + System.getProperty("java.vendor") + " ");
        previousMessage = previousMessage.replaceAll("%java.vendor.url", " " + System.getProperty("java.vendor.url") + " ");
        previousMessage = previousMessage.replaceAll("%java.home", " " + System.getProperty("java.home") + " ");
        previousMessage = previousMessage.replaceAll("%java.vm.specification.version", " " + System.getProperty("java.vm.specification.version") + " ");
        previousMessage = previousMessage.replaceAll("%java.vm.name", " " + System.getProperty("java.vm.name") + " ");
        previousMessage = previousMessage.replaceAll("%java.vm.version", " " + System.getProperty("java.vm.version") + " ");
        previousMessage = previousMessage.replaceAll("%java.class.version", " " + System.getProperty("java.class.version") + " ");
        previousMessage = previousMessage.replaceAll("%java.class.path", " " + System.getProperty("java.class.path") + " ");
        previousMessage = previousMessage.replaceAll("%java.library.path", " " + System.getProperty("java.library.path") + " ");
        previousMessage = previousMessage.replaceAll("%os.arch", " " + System.getProperty("os.arch") + " ");
        previousMessage = previousMessage.replaceAll("%os.version", " " + System.getProperty("os.version") + " ");
        previousMessage = previousMessage.replaceAll("%user.name", " " + System.getProperty("user.name") + " ");
        previousMessage = previousMessage.replaceAll("%user.home", " " + System.getProperty("user.home") + " ");
        previousMessage = previousMessage.replaceAll("%user.dir", " " + System.getProperty("user.dir") + " ");
        previousMessage = previousMessage.replaceAll("%java.compiler", " " + System.getProperty("java.compiler") + " ");
        previousMessage = previousMessage.replaceAll("%file.separator", " " + System.getProperty("file.separator") + " ");
        previousMessage = previousMessage.replaceAll("%java.io.tmpdir", " " + System.getProperty("java.io.tmpdir") + " ");
        return previousMessage;
    }
}
