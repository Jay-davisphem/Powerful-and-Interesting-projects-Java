import java.util.*;
class Test{
  private Scanner scan = new Scanner(System.in);
  private boolean isContinue(){
    System.out.println("Wanna continue?");
    while(true){
      System.out.print("Enter y(es)/n(o): ");
      String cont = scan.next();
      
      switch(cont.toLowerCase()){
        case "y":
        case "yes":
          return true;
        case "n":
        case "no":
          System.out.println("Bye!");
          return false;
        default:
          System.out.println("Wrong input!");
      }
    }
  }
  private String toStr(int val){
    return val <= 9 ? "0"+val : ""+val;
  }
  public void run(){
    Clock clock = new Clock();
    do{
      clock.setTime();
      clock.draw();
      System.out.println(toStr(clock.getHour()) + " : " + toStr(clock.getMinute()));
    } while(false/*isContinue()*/);
  }
  public static void main(String[] args){
    Test test = new Test();
    test.run();
  }
}
