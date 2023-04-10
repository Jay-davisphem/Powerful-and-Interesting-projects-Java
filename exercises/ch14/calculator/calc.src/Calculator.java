import javax.swing.*;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Calculator extends JFrame implements ActionListener{
  public static final int FRAME_WIDTH = 330;
  public static final int FRAME_HEIGTH = 420;
  public static final int LOC_X = 100;
  public static final int LOC_Y = 100;
  public static void main(String[] args){
    Calculator calc = new Calculator();
    calc.setVisible(true);
  }
  public Calculator(){
    Container parent = getContentPane();
    setLocation(LOC_X, LOC_Y);
    setResizable(false);
    setSize(FRAME_WIDTH, FRAME_HEIGTH);

    parent.setBackground(Color.blue);

    setDefaultCloseOperation((EXIT_ON_CLOSE));
  }
  public void actionPerformed(ActionEvent e){}
}
