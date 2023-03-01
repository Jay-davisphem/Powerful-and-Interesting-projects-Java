import javax.swing.*;
import java.awt.*;

class Graphics1{
  public static void main(String[] args){
    JFrame frame = new JFrame("My First Rectangle");
    Container container;
    Graphics graphics;

    frame.setSize(300, 200);
    frame.setLocation(100, 100);
    frame.setVisible(true);

    container = frame.getContentPane();
    container.setBackground(Color.LIGHT_GRAY);
    graphics = container.getGraphics();

    graphics.setColor(Color.RED);
    try{Thread.sleep(200);}catch(Exception e){}
    graphics.drawRect(50, 50, 100, 30);

    graphics.setColor(Color.BLUE);
    try{Thread.sleep(200);}catch(Exception e){}
    graphics.fillRect(175,50,100,30);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
