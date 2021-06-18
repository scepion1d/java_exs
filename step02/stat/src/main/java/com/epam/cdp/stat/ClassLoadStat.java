package com.epam.cdp.stat;

import com.google.common.base.Joiner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ClassLoadStat extends BasicStat {
    private final String jarPath;

    public ClassLoadStat() {
        String jarPath;
        try {
            jarPath = new File(
                    this.getClass()
                        .getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .toURI()
            ).getPath();
        } catch (URISyntaxException e) {
            log.warn("Can't obtain jar path: {}", e.getMessage());
            jarPath = "";
        }

        this.jarPath = jarPath;
    }

    @Override
    public void print() {
        List<String> classes = new ArrayList<>();

        try {
            JarInputStream jarStream = new JarInputStream(new FileInputStream(jarPath));
            JarEntry jarFile;

            while (true) {
                jarFile = jarStream.getNextJarEntry();
                if (jarFile == null) break;

                if ((jarFile.getName().endsWith(".class"))) {
                    String className = jarFile.getName().replaceAll("/", "\\.");
                    String myClass = className.substring(0, className.lastIndexOf('.'));
                    classes.add(myClass);
                }
            }

            Joiner classJoiner = Joiner.on("\n\t\t");

            log.info("Application threads: [\n\t{}\n\t\t{}\n]", jarPath, classJoiner.join(classes));
        } catch (FileNotFoundException e) {
            log.error("Can't load file {}: {}", jarPath, e.getMessage());
        } catch (IOException e) {
            log.error("Can't obtain classes list from the file {}: {}", jarPath, e.getMessage());
        }
    }
}
