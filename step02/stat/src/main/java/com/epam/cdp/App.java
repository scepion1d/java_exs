package com.epam.cdp;

import com.epam.cdp.stat.Statistic;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String... args) throws InterruptedException {
        while (true) {
            new Statistic(args).printAll();
            Thread.sleep(5000); //TODO: fix later, keywords: spin wait, busy waiting
        }
    }
}
