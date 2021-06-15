package com.epam.cdp.stat;

import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

@Log
public class Statistic {
    private final String[] args;

    public Statistic(String[] args) {
        this.args = args;
    }

    public void printAll() {
        log.info("Application statistic:");
        printArgs();
        printEnv();
        printClassPath();
    }

    public void printEnv() {
        Map<String, String> env = System.getenv();

        log.info("Application environment:");
        for (Map.Entry<String, String> entry : env.entrySet()) {
            log.info(String.format("%s : %s'n", entry.getKey(), entry.getValue()));
        }
    }

    public void printArgs() {
        log.info("Command line arguments:");
        int i = 1;
        for (String arg : args) {
            log.info(String.format("Arg. %d: %s\n", i, arg));
            i++;
        }
    }

    public void printClassPath() {
        URLClassLoader cl = (URLClassLoader) ClassLoader.getSystemClassLoader();

        URL[] urls = cl.getURLs();

        log.info("Application class path:");
        for (URL url : urls) {
            log.info(url.getPath());
        }
    }
}