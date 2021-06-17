package com.epam.cdp.stat;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ClassLoadStat extends BasicStat {
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
        String header = thread.getId() + " " + thread.getName() + "\n";

        String trace = Arrays.stream(thread.getStackTrace())
                .map(x -> {
                   return x.getFileName() + ":" + x.getLineNumber() + "#" + x.getMethodName();
                })
                .collect(Collectors.joining("\n\t\t"));

        return header + "\t\t" + trace;
    }
}
