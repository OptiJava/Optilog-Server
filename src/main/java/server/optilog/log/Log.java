package server.optilog.log;

public interface Log {
    static Optilog initLog(String pathOfSettingFile) {
        Logger.initlog(pathOfSettingFile);
        return new Optilog();
    }
    
    static Optilog reInitLog() {
        return new Optilog();
    }
    
    void info();
    
    void info(long var1);
    
    void info(Optilog var1);
    
    void info(double var1);
    
    void info(char[] var1);
    
    void info(short var1);
    
    void info(int var1);
    
    void info(float var1);
    
    void info(String var1);
    
    void info(Object var1);
    
    void error();
    
    void error(long var1);
    
    void error(Optilog var1);
    
    void error(double var1);
    
    void error(char[] var1);
    
    void error(short var1);
    
    void error(int var1);
    
    void error(float var1);
    
    void error(String var1);
    
    void error(Object var1);
    
    void warn();
    
    void warn(long var1);
    
    void warn(Optilog var1);
    
    void warn(double var1);
    
    void warn(char[] var1);
    
    void warn(short var1);
    
    void warn(int var1);
    
    void warn(float var1);
    
    void warn(String var1);
    
    void warn(Object var1);
    
    void debug();
    
    void debug(long var1);
    
    void debug(Optilog var1);
    
    void debug(double var1);
    
    void debug(char[] var1);
    
    void debug(short var1);
    
    void debug(int var1);
    
    void debug(float var1);
    
    void debug(String var1);
    
    void debug(Object var1);
    
    void command(String var1);
}