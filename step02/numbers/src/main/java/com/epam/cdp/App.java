package com.epam.cdp;

import com.epam.cdp.tree.Tree;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println(fibonacci(Integer.parseInt(args[0])));
        Tree tree = new Tree(10);
    }

    public static double fibonacci(Integer n) {
        if (n <= 1) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
