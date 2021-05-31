package com.epam.cdp.logger;

import org.slf4j.LoggerFactory;

public class LogbackLogger implements com.epam.cdp.logger.Logger {
    private org.slf4j.Logger logger;

    public LogbackLogger() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public void debug(String data) { this.logger.debug(data); }

    public void info(String data) { this.logger.info(data); }

    public void warn(String data) { this.logger.warn(data); }

    public void error(String data) { this.logger.error(data); }
}
