package com.epam.cdp.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger {
    protected static final String log_format = "%-33s: %s%n";

    public abstract void debug(String data);

    public abstract void info(String data);

    public abstract void warn(String data);

    public abstract void error(String data);

    protected String formatted_prefix(String prefix_type) {
        String prefix = String.format("[%s]", prefix_type);
        SimpleDateFormat date_formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS");
        return String.format("%-7s %s", prefix, date_formatter.format(new Date()));
    }
}
