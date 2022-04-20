/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Rational implements Comparable<Rational> {

    private final int numerator, denominator; // p, q
    private static final Rational zero = new Rational(0, 1);

    public static Rational getZero() {
        return zero;
    }

    public Rational(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator < 0) {
            throw new IllegalArgumentException("Entered negative denominator");
        } else if (denominator == 0) {
            throw new ArithmeticException("Denominator is zero");
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public boolean greaterThan(Rational r) {
        if (compareTo(r) <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Rational r) {
        return Integer.compare(this.numerator * r.getDenominator(), this.denominator * r.getNumerator());
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Rational)) {
            return false;
        }
        if (obj == this) { // if it is the current object
            return true;
        }
        Rational r = (Rational) obj;
        return compareTo(r) == 0;
    }

    public Rational plus(Rational r) {
        int num = this.numerator * r.getDenominator() + this.denominator * r.getNumerator();
        int dem = this.denominator * r.getDenominator();
        return new Rational(num, dem).reduce();
    }

    public Rational minus(Rational r) {
        int num = this.numerator * r.getDenominator() - this.denominator * r.getNumerator();
        int dem = this.denominator * r.getDenominator();
        return new Rational(num, dem).reduce();
    }

    public Rational multiply(Rational r) {
        int num = this.numerator * r.getNumerator();
        int dem = this.denominator * r.getDenominator();
        return new Rational(num, dem).reduce();
    }

    public Rational divide(Rational r) { // to circumvent dividing by zero
        int num = this.numerator * r.getDenominator();
        int dem = this.denominator * r.getNumerator();
        return new Rational(num, dem).reduce();
    }

    public Rational reduce() throws ArithmeticException {
        try {
            int gdc = gdc(this.numerator, this.denominator);
            return new Rational(this.numerator / gdc, this.denominator / gdc);
        } catch (ArithmeticException e) {
            return zero;
        }

    }

    private int gdc(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (b == 0) {
            return a;
        }
        int x = a % b;
        return gdc(b, x);
    }

}
