import java.util.*;
import java.awt.*;
import javax.swing.*;
class Clock{
  private static final int WIDTH = 200;
  private static final int HEIGHT = 200;
  private static final int SLEEP_TIME = 300;
  private Scanner scan;
  private JFrame frame;
  private Container c;
  private Graphics g;
  private int hour, minute;
  public Clock(){
    scan = new Scanner(System.in);
  }
  public int getHour(){
    return hour;
  }
  public int getMinute(){
    return minute;
  }
  public void setTime(){
    boolean wrong = false;
    do{
      System.out.print("Enter hour in range 0-12: ");
      hour = scan.nextInt();
      wrong = hour < 0 || hour > 12;
      if(wrong)
        System.out.println("Wrong hour!");
    }while(wrong);
    
    do{
      System.out.print("Enter minute in range 0-59: ");
      minute = scan.nextInt();
      wrong = minute < 0 || minute > 59;
      if(wrong)
        System.out.println("Wrong minute!");
    }while(wrong);
  }
  private String toStr(int val){
    return val <= 9 ? "0"+val : ""+val;
  }
  private double getMinuteAngle(){
    return (90 - minute*6.0)*Math.PI/180;
  }
  private void drawRim(){
    try{
      Thread.sleep(SLEEP_TIME);
      g.drawOval(100, 100, WIDTH, HEIGHT);
      
      Thread.sleep(SLEEP_TIME);
      g.fillOval(195, 195, 10, 10);
    }catch(Exception e){}
  }
  private void drawHands(){
    try{
      double toX = 200+50*Math.cos(getHourAngle());
      double toY = 200-50*Math.sin(getHourAngle());
      Thread.sleep(SLEEP_TIME);
      g.drawLine(200, 200, (int)toX, (int)toY);
      
      toX = 200+70*Math.cos(getMinuteAngle());
      toY = 200-70*Math.sin(getMinuteAngle());
      Thread.sleep(SLEEP_TIME);
      g.setColor(Color.BLACK);
      g.drawLine(200, 200, (int)toX, (int)toY);
    }catch(Exception e){}
  }
  private void writeStr(int num, int x, int y){
    try{
      Thread.sleep(SLEEP_TIME);
      g.drawString(""+num, x, y);
    }catch(Exception e){}
  }
  private double getHourAngle(){
    return (90 - (hour + minute/90.0)*30.0)*Math.PI/180;
  }

  private void writeClockString(){
    int pad = 20;
    writeStr(12, 200 - pad/4, 100 + pad);
    writeStr(3, 300 - pad, 200 + pad/4);
    writeStr(6, 200 - pad/4, 300 - pad/2);
    writeStr(9, 100 + pad/2, 200 + pad/4);
  }
  public void draw(){
   frame = new JFrame(toStr(hour) + ":" + toStr(minute));
   frame.setSize(600, 600);
   frame.setLocation(0, 0);
   frame.setVisible(true);
   
   c = frame.getContentPane();
   g = c.getGraphics();
  
   drawRim();
   drawHands();
   writeClockString();

   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
