import java.util.*;
class RSA{
  private static final long p = 758596687L;
  private static final long q = 136295909L;
  private static final long n = p*q;
  private static long e;
  private static long y;
  private static long d;
  private Random random;
  public RSA(){
    random =  new Random();
    e = getE(1);
    y = getY();
    d = getD();
  }

  /*
   * y = (p - 1) * (q - 1)
   * @return: y
  */
  private long getY(){
    return (p - 1)*(q - 1);
  }
  

  /*
   * e < n and y % e != 0
   * @return: e
  */
  private long getE(long randLong){
    for (randLong = randLong; randLong < n; randLong++)
      System.out.print(randLong + " ");
      if ((y % randLong) != 0)
        return randLong;
    return 1;
  }

  /*
   * Each character is an ASCII code.
   * @return: encoded ascii character
  */
  private long encodeChr(char m){
    return (long) (Math.pow((double)m, (double)e) % (double)n);
  }
  /*
   * Each character is an ASCII code.
   * @return: encoded ascii characters as list of long
  */
  public long[] encodeStr(String str){
    char[] charList = str.toCharArray();
    int len = charList.length;
    long[] encVal = new long[len];
    
    for(int i = 0; i < len; i++){
      encVal[i] = encodeChr(charList[i]);
    }

    return encVal;
  }

  private long getD(){
    for (int d = 1; d <= n; d++){
      if ((e*d) % y == 1)
        return d;
    }
    return 5L;
  }
  /*
   * Each character is a long value encoded from ASCII char.
   * @return: ASCII character
  */
  private char decodeChr(long c){
    return (char) (Math.pow((double)c, (double)d) % (double)n);
  }
  /*
   * Each character is a long value encoded from ASCII char.
   * @return: ASCII characters str values as decoded
  */
  public String decodeStr(long[] encVal){
    int len = encVal.length;
    char[] decVal = new char[len];
    
    for(int i = 0; i < len; i++){
      decVal[i] = decodeChr(encVal[i]);
    }

    return decVal.toString();
  }

  public static void main(String[] args){
    String msg =  "I love jesus!";

    RSA rsa = new RSA();
    long[] enc = rsa.encodeStr(msg);
    String dec = rsa.decodeStr(enc);
    System.out.println(dec);
  }
}
