package com.epam.cdp;

import com.epam.cdp.array.Array;
import com.epam.cdp.string.LettersFrequency;

public class App 
{
    public static void main( String[] args ) {
        new Array(1000).print();
        new LettersFrequency("yyAABBCCyc").print();
    }
}
