package server.optilog.log.console;

import server.optilog.log.Logger;
import server.optilog.setting.SettingFiles;
import server.optilog.util.exception.CreateFileErrorException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Console {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
    public static String ts;
    public static boolean print;
    static File file;
    
    public Console() {
    }
    
    public static void file() {
        if (SettingFiles.sfcpath == null) {
            print = false;
            throw new CreateFileErrorException("Can't init console because setting console path is null!", new NullPointerException("Console file path is null!"));
        } else {
            if (SettingFiles.sfcpath.isBlank()) {
                print = false;
            } else {
                file = new File(SettingFiles.sfcpath);
                if (!file.isDirectory()) {
                    print = false;
                    System.out.println("Optilog Note: Can't find consolefile folder'" + SettingFiles.sfcpath + "'");
                    throw new CreateFileErrorException("Can't find consolefile folder'" + SettingFiles.sfcpath + "'", new IOException("Console file path isn't directory!"));
                }
                
                print = file.canRead();
            }
            
            if (print) {
                try {
                    File file1 = new File(SettingFiles.sfcpath + "//" + ts + "Log(Server).log");
                    if (!file1.createNewFile()) {
                        print = false;
                        System.out.println("Optilog Note: Failed to create log file!");
                        throw new CreateFileErrorException("Failed to create log file");
                    }
                    
                    if (print) {
                        Logger.INFOO = new FileOutputStream(SettingFiles.sfcpath + "//" + ts + "Log(Server).log");
                    }
                } catch (Exception var1) {
                    print = false;
                    System.out.println("Optilog Note: IOException was thrown when create New LogFile");
                    var1.printStackTrace();
                }
            }
            
        }
    }
    
    static {
        ts = dtf.format(LocalDateTime.now());
        print = true;
    }
}