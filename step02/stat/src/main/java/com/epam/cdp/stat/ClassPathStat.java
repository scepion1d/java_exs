package com.epam.cdp.stat;

import com.google.common.base.Joiner;

public class ClassPathStat extends BasicStat {
    @Override
    public void print() {
        String classPathAsString = System.getProperty("java.class.path");

        String[] paths = classPathAsString.split(";");
        Joiner joiner = Joiner.on(",\n\t");

        log.info("Application class path: [\n\t{}\n]", joiner.join(paths));
    }
}
