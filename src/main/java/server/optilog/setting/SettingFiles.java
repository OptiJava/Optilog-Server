package server.optilog.setting;


import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class SettingFiles {
    public static boolean sferror = true;
    public static boolean sfinfo = true;
    public static boolean sfdebug = true;
    public static boolean sfwarn = true;
    public static boolean sffatal = true;
    public static String sfcpath = "";
    public static boolean cinfo = true;
    public static boolean cerror = true;
    public static boolean cdebug = true;
    public static boolean cwarn = true;
    public static boolean cfatal = true;
    public static int socketNumber = 65535;
    private static Settings object;
    
    public SettingFiles() {
    }
    
    public static void check(String str) throws IOException {
        if (!str.isBlank()) {
            getSetting(str);
        }
        
    }
    
    public static void getSetting(String s) throws IOException {
        try {
            String content = Files.readString(Paths.get(s), StandardCharsets.UTF_8);
            object = new Gson().fromJson(content, Settings.class);
        } catch (NoSuchFileException var2) {
            var2.printStackTrace();
            System.exit(1);
        }
        
        sfcpath = object.printPath;
        sfdebug = object.printDebug;
        sfinfo = object.printInfo;
        sferror = object.printError;
        sfwarn = object.printWarn;
        sffatal = object.printFatal;
        cerror = object.consoleError;
        cdebug = object.consoleDebug;
        cinfo = object.consoleInfo;
        cwarn = object.consoleWarn;
        cfatal = object.consoleFatal;
        socketNumber = object.socketNumber;
    }
}
