package com.epam.cdp.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Starting the application ...");
        SpringApplication.run(Application.class, args);
        logger.info("Application finished");
    }

    @Override
    public void run(String[] args) throws Exception { }

    @Scheduled(fixedDelay = 5000)
    private static void find_prime_numbers() {
        int lower  = -1000;
        int higher = 1000;
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
