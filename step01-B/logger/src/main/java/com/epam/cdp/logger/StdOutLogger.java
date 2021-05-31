package com.epam.cdp.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdOutLogger extends Logger {

    public void debug(String data) {
        System.err.printf(log_format, formatted_prefix("DEBUG"), data);
    }

    public void info(String data) {
        System.err.printf(log_format, formatted_prefix("INFO"), data);
    }

    public void warn(String data) {
        System.err.printf(log_format, formatted_prefix("WARN"), data);
    }

    public void error(String data) {
        System.err.printf(log_format, formatted_prefix("ERROR"), data);
    }
}
