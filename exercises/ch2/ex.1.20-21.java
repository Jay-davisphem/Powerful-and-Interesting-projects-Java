/*
 * A program that displays today's date 
 * in format 10 December, 2008 and 
 * Monday December 10, 2008
*/ 

import java.util.Date;
import java.text.SimpleDateFormat;
class TodayDate {
  public static void main(String[] args){
    Date today;
    SimpleDateFormat dateFormat;
    today = new Date();
    dateFormat = new SimpleDateFormat("dd MMMM, yyyy"); // 14 February, 2023
    System.out.println("Today date is " + dateFormat.format(today));

    dateFormat = new SimpleDateFormat("EEEE MMMM dd, yyyy"); // Monday December 10, 2008
    System.out.println("Today date is " + dateFormat.format(today));
    
    dateFormat = new SimpleDateFormat("hh:mm a"); // 10:19 AM
    System.out.println("And the time is " + dateFormat.format(today));
  }
}
