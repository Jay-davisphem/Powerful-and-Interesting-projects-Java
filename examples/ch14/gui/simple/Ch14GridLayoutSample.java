/*
Chapter 14 Sample Program: Illustrates the use of GridLayout
File: Ch14GridLayoutSample.java
*/
import javax.swing.*;
import java.awt.*;
class Ch14GridLayoutSample extends JFrame {
  protected static final long serialVersionUID = 100L;
  private static final int FRAME_WIDTH = 300;
  private static final int FRAME_HEIGHT = 200;
  private static final int FRAME_X_ORIGIN = 150;
  private static final int FRAME_Y_ORIGIN = 250;
  public static void main(String[] args) {
    Ch14GridLayoutSample frame = new Ch14GridLayoutSample();
    frame.setVisible(true);
  }
  public Ch14GridLayoutSample() {
    Container contentPane;
    JButton button1, button2, button3, button4, button5, button6, button7;
    //set the frame properties
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setTitle("Program Ch14GridLayoutSample");
    setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
    contentPane = getContentPane( );
    contentPane.setBackground( Color.WHITE );
    contentPane.setLayout(new GridLayout(2, 4));
    contentPane.setMaximumSize(new Dimension(500, 200));
    //create and place five buttons on the content pane
    button1 = new JButton("button 1");
    button2 = new JButton("button 2");
    button3 = new JButton("button 3");
    button4 = new JButton("button 4");
    button5 = new JButton("button 5");
    button6 = new JButton("button 6");
    button7 = new JButton("button 7");
    contentPane.add(button1);
    contentPane.add(button2);
    contentPane.add(button3);
    contentPane.add(button4);
    contentPane.add(button5);
    contentPane.add(button6);
    contentPane.add(button7);
    //register 'Exit upon closing' as a default close operation
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }
}


