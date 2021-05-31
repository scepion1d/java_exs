package com.epam.cdp.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdOutLogger implements Logger {
    protected static final String log_format = "%-33s: %s%n";

    public void debug(String data) {
        System.out.printf(log_format, formatted_prefix("DEBUG"), data);
    }

    public void info(String data) {
        System.out.printf(log_format, formatted_prefix("INFO"), data);
    }

    public void warn(String data) {
        System.err.printf(log_format, formatted_prefix("WARN"), data);
    }

    public void error(String data) {
        System.err.printf(log_format, formatted_prefix("ERROR"), data);
    }

    protected String formatted_prefix(String log_level) {
        String prefix = String.format("[%s]", log_level);
        SimpleDateFormat date_formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS");
        return String.format("%-7s %s", prefix, date_formatter.format(new Date()));
    }
}
