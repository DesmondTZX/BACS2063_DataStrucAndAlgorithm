package fraction;

public class Fraction implements FractionInterface {
    
    private int numerator, denominator;

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    @Override
    public int getNumerator() {
        return this.numerator;
    }

    @Override
    public int getDenominator() {
        return this.denominator;
    }

    @Override
    public FractionInterface add(FractionInterface frac) {
        int a = this.numerator;
        int b = this.denominator;
        
        int c = frac.getNumerator();
        int d = frac.getDenominator();
        
        int resultNumerator = a * d + b * c;
        int resultDenominator = b * d;
        return new Fraction(resultNumerator, resultDenominator);
    }

    @Override
    public FractionInterface subtract(FractionInterface frac) {
        int a = this.numerator;
        int b = this.denominator;
        
        int c = frac.getNumerator();
        int d = frac.getDenominator();
        
        int resultNumerator = a * d - b * c;
        int resultDenominator = b * d;
        return new Fraction(resultNumerator, resultDenominator);
    }

    @Override
    public FractionInterface multiply(FractionInterface frac) {
        int a = this.numerator;
        int b = this.denominator;
        
        int c = frac.getNumerator();
        int d = frac.getDenominator();
        
        int resultNumerator = a * c;
        int resultDenominator = b * d;
        return new Fraction(resultNumerator, resultDenominator);
    }

    @Override
    public FractionInterface divide(FractionInterface frac) {
        int a = this.numerator;
        int b = this.denominator;
        
        int c = frac.getNumerator();
        int d = frac.getDenominator();
        
        int resultNumerator = a * d;
        int resultDenominator = b * c;
        return new Fraction(resultNumerator, resultDenominator);
    }

    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }
    
    
    
}
