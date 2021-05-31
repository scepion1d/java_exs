package com.epam.cdp;

import com.epam.cdp.logger.Logger;
import com.epam.cdp.logger.StdOutLogger;

import static java.lang.Thread.sleep;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
        Logger logger = new StdOutLogger();

        while (true) {
            find_prime_numbers(-1000, 1000, logger);
            sleep(5000);
        }
    }

    private static void find_prime_numbers(int lower, int higher, Logger logger) {
        logger.info(String.format("Looking for prime numbers in range from %d to %d", lower, higher));

        for (int i = lower; i <= higher; i++) {
            if (i == 0) continue; // skip 0

            boolean is_prime = true;

            for (int divider = 2; divider < Math.abs(i); divider++) {
                if (i % divider == 0) {
                    is_prime = false;
                    break;
                }
            }

            if (is_prime) logger.debug(String.valueOf(i));
        }

        logger.info("Hello world!");
    }
}
