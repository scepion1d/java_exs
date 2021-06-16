package com.epam.cdp.stat;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarker;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
public class Statistic {
    private final String[] args;

//    public Statistic(String[] args) { // used RequiredArgsConstructor to reduce amount of brackets/boilerplate code
//        this.args = args;
//    }

    public void printAll() {
        log.info("Application statistic:");
        printArgs();
        printEnv();
        printClassPath();
        printAllSystemProperties();
        log.info("Logging done");
    }

    public void printEnv() {
        Map<String, String> envMap = System.getenv();
        Joiner.MapJoiner mapJoiner = Joiner.on(",\n\t").withKeyValueSeparator("="); //just example of google guava
        log.info("Application environment: [\n{}\n]", mapJoiner.join(envMap));
            //don't output data in a cycle, because in concurrent system you can have
            //a situtation when your log will have `splitted` values from different threads in incomprentable order;

    }

    public void printArgs() {
        log.info("Command line arguments:");
        log.info("Arguments: {}", Arrays.asList(args));
    }

    public void printClassPath() {
        //approach with geeting class path as a system property;
        String classPathAsString = System.getProperty("java.class.path");
        String[] split = classPathAsString.split(";");
        //        ArrayList<String> classPathAsList = Lists.newArrayList(split); //don't need it, joiner can work with raw arrays;
        Joiner listJoiner = Joiner.on(",\n\t");
        log.info("Application properties: [\n{}\n]", listJoiner.join(split));
    }

    private void printAllSystemProperties() {
        Properties properties = System.getProperties(); //properties just a class which extends a Map<Obj, Obj>
        Joiner.MapJoiner mapJoiner = Joiner.on(",\n\t").withKeyValueSeparator("="); //just example of google guava
        log.info("Application environment: [\n{}\n]", mapJoiner.join(properties));

        //TODO: you should log all this information in a different log file;
        // use Marker or just move logging to obtain special capabilities, like logging to different files like selector,
        // filtering log messages etc;
        //
        // Or just use the different StatisticLogger class of configure your logback xml;
        //
        //        Marker marker = MarkerFactory.getMarker("PROPERTIES_MARKER");
        //        log.info(marker, "some logging is here {}, {}, {}", 1, null, "a");
    }

    //https://gist.github.com/pal/110024/8a845866d3aad6865a4d2cad2b3eff112b61b1d5
    // here an example with obtaining jar files from the class path;
    // also by found jar files you can also traverse them and got class files inside;




}