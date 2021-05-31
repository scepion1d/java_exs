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
    public void shouldWriteDebugLogIntoStdOut() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "DEBUG"));

        String subject = tapSystemOut(() -> { logger.debug("TEST"); });

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void shouldWriteInfoLogIntoStdOut() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "INFO"));

        String subject = tapSystemOutNormalized(() -> { logger.info("TEST"); });

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void shouldWriteWarnLogIntoStdOut() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "WARN"));

        String subject = tapSystemOutNormalized(() -> { logger.warn("TEST"); });

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }

    @Test
    public void shouldWriteErrorLogIntoStdOut() throws Exception {
        Pattern pattern = Pattern.compile(String.format(log_format, "ERROR"));

        String subject = tapSystemOutNormalized(() -> { logger.error("TEST"); });

        Assertions.assertEquals(true, pattern.matcher(subject).matches());
    }
}
