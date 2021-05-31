package com.epam.cdp.logger;

public interface Logger {
    void debug(String data);

    void info(String data);

    void warn(String data);

    void error(String data);
}
