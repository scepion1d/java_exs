package com.epam.cdp.stat;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ThreadsStat extends BasicStat {
    @Override
    public void print() {
        String threads = Thread
                .getAllStackTraces()
                .keySet()
                .stream()
                .map(this::threadToString)
                .collect(Collectors.joining("\n\t"));

        log.info("Application threads: [\n\t{}\n]", threads);
    }

    private String threadToString(Thread thread) {
        String trace = Arrays.stream(thread.getStackTrace())
                .map(x -> {
                   return x.getFileName() + ":" + x.getLineNumber() + "#" + x.getMethodName();
                })
                .collect(Collectors.joining("\n\t\t"));

        return thread.getId() + " " + thread.getName() + "\n\t\t" + trace;
    }
}
