/*
Chapter 14 Sample Program: Illustrates the use of BorderLayout
File: Ch14BorderLayoutSample.java
*/
import javax.swing.*;
import java.awt.*;
class ChBorderLayoutSample extends JFrame {
  protected static final long serialVersionUID = 2L;
  private static final int FRAME_WIDTH = 400;
  private static final int FRAME_HEIGHT = 200;
  private static final int FRAME_X_ORIGIN = 150;
  private static final int FRAME_Y_ORIGIN = 250;
 
  //---------------------------------
  //Main method
  //---------------------------------
  public static void main(String[] args) {
    ChBorderLayoutSample frame = new ChBorderLayoutSample();
    frame.setVisible(true);
  }
  public ChBorderLayoutSample() {
    Container contentPane;
    JButton button1, button2, button3, button4, button5, button6, button7;
    //set the frame properties
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setTitle("Program Ch14BorderLayoutSample");
    setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
    contentPane = getContentPane( );
    contentPane.setBackground(Color.WHITE);
    contentPane.setLayout(new BorderLayout());
    //contentPane.setLayout(new BorderLayout(/*hgap*/10, /*vgap*/10));
    //create and place four buttons on the content pane
    button1 = new JButton("button 1");
    button2 = new JButton("button 2");
    button3 = new JButton("button 3");
    button4 = new JButton("button 4");
    button5 = new JButton("button 5");
    button6 = new JButton("button 6");
    button7 = new JButton("button 7");
    
    Container ct2 = new Container();
    ct2.setLayout(new FlowLayout());
    ct2.add(button5);
    ct2.add(button4);


    Container ct1 = new Container();
    ct1.setLayout(new FlowLayout());
    ct1.add(button6);
    ct1.add(button7);

    Container ct3 = new Container();
    Container ct4 = new Container();
    Container ct5 = new Container();
    ct3.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    ct4.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    ct5.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    contentPane.add(ct3, BorderLayout.NORTH);
    contentPane.add(ct4, BorderLayout.SOUTH);
    contentPane.add(ct1, BorderLayout.EAST);
    contentPane.add(ct2, BorderLayout.WEST);
    contentPane.add(ct5, BorderLayout.CENTER);
    //register 'Exit upon closing' as a default close operation
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }
}
