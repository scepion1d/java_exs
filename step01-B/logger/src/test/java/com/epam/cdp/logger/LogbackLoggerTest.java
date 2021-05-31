package com.epam.cdp.logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErr;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class LogbackLoggerTest
{
    private static Logger logger = new LogbackLogger();

    private static final String log_format = "%s\\s{1,2}\\d{2}:\\d{2}:\\d{2}\\.\\d{4} com.epam.cdp.logger.LogbackLogger : TEST\\n";

    @Test
    public void should_write_debug_log_into_std_out() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "DEBUG"));

        String subject = tapSystemOut(() -> logger.debug("TEST"));
        System.out.println(pattern);

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void should_write_info_log_into_std_out() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "INFO"));

        String subject = tapSystemOut(() -> logger.info("TEST"));

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void should_write_warn_log_into_std_err() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "WARN"));

        String subject = tapSystemErr(() -> logger.warn("TEST"));

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void should_write_error_log_into_std_err() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "ERROR"));

        String subject = tapSystemErr(() -> logger.error("TEST"));

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }
}
