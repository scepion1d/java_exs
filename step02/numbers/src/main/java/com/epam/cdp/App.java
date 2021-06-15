package com.epam.cdp;

import com.epam.cdp.brackets.BracketsParser;
import com.epam.cdp.brackets.errors.InvalidBracketStateException;
import com.epam.cdp.brackets.errors.NotCorrectBracketException;
import com.epam.cdp.fraction.Fraction;
import com.epam.cdp.tree.Tree;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        int arg = Integer.parseInt(args[0]);

        System.out.println(fibonacci(arg));
        Tree tree = new Tree(arg);
        tree.swap_all_recursive();
        tree.swap_all();

        Fraction a = new Fraction(2, 3);
        Fraction b = new Fraction(3, 4);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(a.add(b).toString());
        System.out.println(a.subtract(b).toString());
        System.out.println(a.multiply(b).toString());
        System.out.println(a.divide(b).toString());

        BracketsParser bracketsParser = new BracketsParser();
        System.out.println(bracketsParser.parse("([<>])[]()[]<><[]>"));
        System.out.println(bracketsParser.parse("<([))>"));
        System.out.println(bracketsParser.parse("([(((())))]"));
    }

    public static double fibonacci(Integer n) {
        if (n <= 1) return n;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
