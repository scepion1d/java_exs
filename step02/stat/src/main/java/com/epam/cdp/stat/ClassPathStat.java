package com.epam.cdp.stat;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class ClassPathStat extends BasicStat {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClassPathStat.class);

    @Override
    public void print() {
        String classPathAsString = System.getProperty("java.class.path");

        String[] paths = classPathAsString.split(";");
        Joiner joiner = Joiner.on(",\n\t");

        log.info("Application class path: [\n\t{}\n]", joiner.join(paths));
    }
}
