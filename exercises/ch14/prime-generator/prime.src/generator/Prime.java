package prime.generator;

public class Prime{
  private Prime(){}
  
  public static boolean isPrime(int num){
    if(num == 0 || num == 1) return false;
    int i = 2;
    while(i <= Math.sqrt((double)num)){
      if(num % i == 0) return false;
      i += 1;
    }
    return true;
  }
  public static int[] first(int n){    
    int[] primes = new int[0];
    if(n < 1) return primes;
    primes = new int[n];
    int count = 1;
    int prime = 2;
    primes[0] = prime;
    if(n == 1){
      return primes;
    }
    prime += 1;
    while(true){
      if(Prime.isPrime(prime)){
        primes[count] = prime;
        count += 1;
        if(count == n) return primes;
      }
      prime += 2;
    }
  }
}
