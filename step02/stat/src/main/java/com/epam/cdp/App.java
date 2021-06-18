package com.epam.cdp;

import com.epam.cdp.stat.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            new EnvStat().print();
            new ArgsStat(args).print();
            new ClassPathStat().print();
            new ThreadsStat().print();
            new FileDescriptorsStat().print();
            new ClassLoadStat().print();

            Thread.sleep(5000);
        }
    }
}
