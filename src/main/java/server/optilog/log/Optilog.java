package server.optilog.log;

public class Optilog implements Log {
    private static final Logger logging = new Logger();
    
    @Override
    public void info() {
        logging.logInfo(" ");
    }
    
    @Override
    public void info(long x) {
        logging.logInfo(String.valueOf(x));
    }
    
    @Override
    public void info(Optilog x) {
        logging.logInfo(x.toString());
    }
    
    @Override
    public void info(double x) {
        logging.logInfo(String.valueOf(x));
    }
    
    @Override
    public void info(char[] x) {
        logging.logInfo(String.valueOf(x));
    }
    
    @Override
    public void info(short x) {
        logging.logInfo(String.valueOf(x));
    }
    
    @Override
    public void info(int x) {
        logging.logInfo(String.valueOf(x));
    }
    
    @Override
    public void info(float x) {
        logging.logInfo(String.valueOf(x));
    }
    
    @Override
    public void info(String x) {
        logging.logInfo(x);
    }
    
    @Override
    public void info(Object x) {
        logging.logInfo(String.valueOf(x));
    }
    
    @Override
    public void error() {
        logging.logError(" ");
    }
    
    @Override
    public void error(long x) {
        logging.logError(String.valueOf(x));
    }
    
    @Override
    public void error(Optilog x) {
        logging.logError(String.valueOf(x));
    }
    
    @Override
    public void error(double x) {
        logging.logError(String.valueOf(x));
    }
    
    @Override
    public void error(char[] x) {
        logging.logError(String.valueOf(x));
    }
    
    @Override
    public void error(short x) {
        logging.logError(String.valueOf(x));
    }
    
    @Override
    public void error(int x) {
        logging.logError(String.valueOf(x));
    }
    
    @Override
    public void error(float x) {
        logging.logError(String.valueOf(x));
    }
    
    @Override
    public void error(String x) {
        logging.logError(x);
    }
    
    @Override
    public void error(Object x) {
        logging.logError(x.toString());
    }
    
    @Override
    public void warn() {
        logging.logWarn(" ");
    }
    
    @Override
    public void warn(long x) {
        logging.logWarn(String.valueOf(x));
    }
    
    @Override
    public void warn(Optilog x) {
        logging.logWarn(x.toString());
    }
    
    @Override
    public void warn(double x) {
        logging.logWarn(String.valueOf(x));
    }
    
    @Override
    public void warn(char[] x) {
        logging.logWarn(String.valueOf(x));
    }
    
    @Override
    public void warn(short x) {
        logging.logWarn(String.valueOf(x));
    }
    
    @Override
    public void warn(int x) {
        logging.logWarn(String.valueOf(x));
    }
    
    @Override
    public void warn(float x) {
        logging.logWarn(String.valueOf(x));
    }
    
    @Override
    public void warn(String x) {
        logging.logWarn(x);
    }
    
    @Override
    public void warn(Object x) {
        logging.logWarn(x.toString());
    }
    
    @Override
    public void debug() {
        logging.logDebug(" ");
    }
    
    @Override
    public void debug(long x) {
        logging.logDebug(String.valueOf(x));
    }
    
    @Override
    public void debug(Optilog x) {
        logging.logDebug(String.valueOf(x));
    }
    
    @Override
    public void debug(double x) {
        logging.logDebug(String.valueOf(x));
    }
    
    @Override
    public void debug(char[] x) {
        logging.logDebug(String.valueOf(x));
    }
    
    @Override
    public void debug(short x) {
        logging.logDebug(String.valueOf(x));
    }
    
    @Override
    public void debug(int x) {
        logging.logDebug(String.valueOf(x));
    }
    
    @Override
    public void debug(float x) {
        logging.logDebug(String.valueOf(x));
    }
    
    @Override
    public void debug(String x) {
        logging.logDebug(x);
    }
    
    @Override
    public void debug(Object x) {
        logging.logDebug(x.toString());
    }
    
    @Override
    public void command(String cmd) {
        Logger.logCommand(cmd);
    }
}

