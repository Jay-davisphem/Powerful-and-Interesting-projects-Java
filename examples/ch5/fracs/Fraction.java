package fracs;

public class Fraction{
  private int _numerator;
  private int _denominator;

  public Fraction(){
    this(0, 1);
  }
  public Fraction(int number){
    this(number, 1);
  }
  public Fraction(Fraction frac){
    this(frac.getNumerator(), frac.getDenominator());
  }
  public Fraction(int numerator, int denominator){
    if(denominator < 0){
      numerator *= -1;
      denominator *= -1;
    }
    if(numerator == 0)
      denominator = 1;

    setNumerator(numerator);
    setDenominator(denominator);
  }

  public String toString(){
    return _numerator + "/" + _denominator;
  }

  public void setNumerator(int numerator){
    _numerator = numerator;
  }

  public void setDenominator(int denominator){
    _denominator = denominator;
  }

  public int getNumerator(){
    return _numerator;
  }

  public int getDenominator(){
    return _denominator;
  }

  private int gcd(int a, int b){
    if (a % b == 0)
      return b;
    return gcd(b, a%b);
  }
  public Fraction simplify(){
    int hcf = gcd(_numerator, _denominator);
    return new Fraction(_numerator/hcf, _denominator/hcf);
  }
  public String getInLowestTerm(){
    return simplify().toString();
  }

  public boolean equals(Fraction frac2){
    String frac1 = getInLowestTerm();
    return frac1.equals(frac2.getInLowestTerm());
  }
  public Fraction add(Fraction frac){
    int sNum = this._numerator*frac._denominator + this._denominator*frac._numerator;
    int sDen = this._denominator * frac._denominator;
    return new Fraction(sNum, sDen);
  }
  public Fraction subtract(Fraction frac){
    int sNum = this._numerator*frac._denominator - this._denominator*frac._numerator;
    int sDen = this._denominator * frac._denominator;
    return new Fraction(sNum, sDen);
  }
  public Fraction multiply(Fraction frac){
    return new Fraction(this._numerator*frac._numerator, this._denominator*frac._denominator);
  }
  public Fraction divide(Fraction frac){
    return new Fraction(this._numerator*frac._denominator, this._denominator*frac._numerator);
  }
}
