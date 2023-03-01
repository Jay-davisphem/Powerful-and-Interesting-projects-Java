/*
 * Solution to exercise 22-24 for the level two
*/
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JFrame;
class Level2Frame1{
  public static void main(String[] args){
    // The dynamic window's property
    String title; 
    int W, H;

    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter(System.getProperty("line.separator"));

    System.out.print("Enter width: ");
    W = scanner.nextInt();    
    System.out.print("Enter heigth: ");
    H = scanner.nextInt();
    System.out.print("Enter window's title: ");
    title = scanner.next().trim();
    
    Date today = new Date();
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a"); // 06:52:32 AM
    
    // Dynamic window of size W, H
    JFrame dyWindow = new JFrame(title + " " + timeFormat.format(today)); 
    dyWindow.setSize(W, H);
    // changing location in pixel(position relative left, top of the screen)
    dyWindow.setLocation(100, 50);
    dyWindow.setVisible(true);
    dyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
