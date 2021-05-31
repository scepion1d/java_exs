package com.epam.cdp.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface Logger {

    public void debug(String data);

    public void info(String data);

    public void warn(String data);

    public void error(String data);
}
