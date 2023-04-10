package teach.util; 
import fracs.*;
import java.util.*;
public class ArithmeticUtil{
  private static Random random;
  public static final String ADD = "+";
  public static final String SUB = "-";
  public static final String DIV = "/";
  public static final String MUL = "x";
  
  public ArithmeticUtil(){
    random = new Random();
  }
  public int getRandomOpd(int digit){
    int num = 1;
    for(int i = 0; i < digit; i++)
      num *= 10;
    --num;
    return random.nextInt(num) + 1;
  }
  public String getRandomOp(){
    int intOp = random.nextInt(4) + 1;
    if(intOp == 1)
      return ADD;
    else if(intOp == 2)
      return SUB;
    else if(intOp == 3)
      return DIV;
    else
      return MUL;
  }
  public boolean check(int opd1, int opd2, String op, int answer){
    Fraction frac1 = new Fraction(opd1);
    Fraction frac2 = new Fraction(opd2);
    Fraction result;
    if(op == ADD){
      result = frac1.add(frac2);
    } else if(op == SUB){
      result = frac1.subtract(frac2);
    }else if(op == DIV){
      result = frac1.divide(frac2);
    }else{
      result = frac1.multiply(frac2);
    }
    return result.getNumerator() == answer;
  }
}
