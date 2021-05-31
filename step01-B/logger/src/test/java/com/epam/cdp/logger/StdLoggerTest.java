package com.epam.cdp.logger;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class StdLoggerTest
{
    private static Logger logger = new StdOutLogger();

    private static final String log_format = "\\[%s\\]\\s{1,2}\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{4} : TEST\\n";

    @Test
    public void should_write_debug_log_into_std_out() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "DEBUG"));

        String subject = tapSystemErr(() -> logger.debug("TEST"));

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void should_write_info_log_into_std_out() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "INFO"));

        String subject = tapSystemErr(() -> logger.info("TEST"));

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void should_write_warn_log_into_std_out() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "WARN"));

        String subject = tapSystemErr(() -> logger.warn("TEST"));

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void should_write_error_log_into_std_out() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "ERROR"));

        String subject = tapSystemErr(() -> logger.error("TEST"));

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }
}
