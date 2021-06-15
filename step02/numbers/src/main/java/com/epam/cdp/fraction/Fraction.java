package com.epam.cdp.fraction;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class Fraction {
    private final long numerator;
    private final long denominator;

    public Fraction(long numerator, long denominator) {
        long gcd = this.gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private long gcd(long x, long y) {
        BigInteger b1 = BigInteger.valueOf(x);
        BigInteger b2 = BigInteger.valueOf(y);

        return b1.gcd(b2).longValue();
    }

    public Fraction add(Fraction fraction) {
        long numerator = this.numerator * fraction.getDenominator() + this.denominator * fraction.getNumerator();
        long denominator = this.denominator * fraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public Fraction subtract(Fraction fraction) {
        long numerator = this.numerator * fraction.getDenominator() - this.denominator * fraction.getNumerator();
        long denominator = this.denominator * fraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public Fraction multiply(Fraction fraction) {
        long numerator = this.numerator * fraction.getNumerator();
        long denominator = this.denominator * fraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public Fraction divide(Fraction fraction) {
        long numerator = this.numerator * fraction.getDenominator();
        long denominator = this.denominator * fraction.getNumerator();

        return new Fraction(numerator, denominator);
    }

    public String toString() {
        return String.format("%d/%d", this.numerator, this.denominator);
    }

    public double toDecimal() {
        return (double) this.numerator / this.denominator;
    }
}
