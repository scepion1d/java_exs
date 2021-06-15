package com.epam.cdp;

import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            out_of_mem_easy();
        } catch (OutOfMemoryError error) {
            System.out.format("OutOfMemory: %s\n", error.getMessage());
        }

        try {
            out_of_mem_hard();
        } catch (OutOfMemoryError error) {
            System.out.format("OutOfMemory: %s\n", error.getMessage());
        }

        try {
            stack_overflow();
        } catch (StackOverflowError error) {
            System.out.format("StackOverflowError: %s\n", error.getMessage());
        }
    }

    private static void out_of_mem_easy() {
        long[] array = new long[Integer.MAX_VALUE];
    }

    private static void out_of_mem_hard() {
        List<long[]> list = new LinkedList<>();

        while (true) {
            list.add(new long[65536]);
        }
    }

    private static void stack_overflow() {
        stack_overflow();
    }
}
