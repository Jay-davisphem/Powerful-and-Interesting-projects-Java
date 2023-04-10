import javax.swing.*;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Calculator extends JFrame implements ActionListener, KeyListener{
  public static final int FRAME_WIDTH = 330;
  public static final int FRAME_HEIGTH = 405;
  public static final String TITLE = "Calcultator1.0 - %1$s x %2$s";
  public static final int LOC_X = 50;
  public static final int LOC_Y = 50;
  private String labelText = "";
  private JLabel label1;
  public static void main(String[] args){
    Calculator calc = new Calculator();
    calc.setVisible(true);
  }
  public Calculator(){
    label1 = new JLabel();
    setLabelStyle(label1);
    Container parent1 = getContentPane();
    parent1.setLayout(new FlowLayout());
    parent1.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGTH));
    Container parent = new Container();
    parent.setLayout(new GridLayout(5, 0, 8, 8));
    setLocation(LOC_X, LOC_Y);
    setTitle(String.format(TITLE, FRAME_WIDTH, FRAME_HEIGTH));
    setResizable(false);
    setSize(FRAME_WIDTH, FRAME_HEIGTH);
    
    JPanel panel1 = getPanel(1, Color.blue, 8, 8);
    panel1.setBackground(Color.black);
    JPanel panel2 = getPanel(1, Color.blue, 8, 8);
    JPanel panel3 = getPanel(1, Color.blue, 8, 8); 
    JPanel panel4 = getPanel(1, Color.blue, 8, 8);
    JPanel panel5 = getPanel(1, Color.blue, 8, 8);
    JPanel panel5a = getPanel(2, Color.blue, 8, 8);
    JPanel panel5ai = getPanel(1, Color.blue, 8, 8);
    JPanel panel5aii = getPanel(1, Color.blue, 8, 8);
    JPanel panel5b = getPanel(2, Color.blue, 8, 8);
    JPanel panel5bi = getPanel(1, Color.blue, 8, 8);
    JPanel panel5bii = getPanel(1, Color.blue, 8, 8);
    JPanel panel5c = getPanel(1, Color.blue, 8, 8);
    JPanel panel5ci = getPanel(1, Color.blue, 8, 8);

    panel1.setBackground(Color.blue);
    panel2.setBackground(Color.blue);
    panel3.setBackground(Color.blue);
    panel4.setBackground(Color.blue);
    
    JScrollPane scrollPane = getLabel(label1, "");
    panel1.setBackground(Color.black);

    JButton btn1 = getButton("1");
    JButton btn2 = getButton("2");
    JButton btn3 = getButton("3");
    JButton btn4 = getButton("4");
    JButton btn5 = getButton("5");
    
    JButton btn6 = getButton("6");
    JButton btn7 = getButton("7");
    JButton btn8 = getButton("8");
    JButton btn9 = getButton("9");
    JButton btnX = getButton("X");
    JButton btnDiv = getButton("/");
    JButton btnMinus = getButton("-");
    JButton btnAdd = getButton("+");

    JButton btnZero = getButton("0");
    JButton btnDot = getButton(".");
    JButton btnC = getButton("C");
    JButton btnCE = getButton("CE");
    JButton btnEqual = getButton("=");
  

    panel1.add(label1);

    panel2.add(btn7);
    panel2.add(btn8);
    panel2.add(btn9);
    panel2.add(btnX);

    panel3.add(btn4);
    panel3.add(btn5);
    panel3.add(btn6);
    panel3.add(btnDiv);

    panel4.add(btn1);
    panel4.add(btn2);
    panel4.add(btn3);
    panel4.add(btnMinus);
 
    panel5ai.add(btnZero);
    panel5aii.add(btnDot);
    panel5aii.add(btnC);
    panel5a.add(panel5ai);
    panel5a.add(panel5aii);
    panel5.add(panel5a);

    panel5bi.add(btnEqual);
    panel5bii.add(btnCE);
    panel5b.add(panel5bi);
    panel5b.add(panel5bii);
    panel5.add(panel5b);

    panel5ci.add(btnAdd);
    panel5c.add(panel5ci);
    panel5.add(panel5c);


    panel5.setBackground(Color.blue);


    parent.add(panel1);
    parent.add(panel2);
    parent.add(panel3);
    parent.add(panel4);
    parent.add(panel5);
    
    parent.setBackground(Color.blue);
    parent1.setBackground(Color.blue);
    parent1.add(parent);

    setDefaultCloseOperation((EXIT_ON_CLOSE));
  }
  public JPanel getPanel(int rows, Color color, int margX, int margY){
    JPanel panel = new JPanel(new GridLayout(rows, 0, margX, margY));
    panel.setBackground(color);
    return panel;
  }
  public JButton getButton(String name){
    JButton button = new JButton(name);
    button.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
    button.addActionListener(this);
    return button;
  }
  public void setLabelStyle(JLabel label){
    label.setFont(new Font(Font.SERIF, Font.BOLD, 25));
    label.setBackground(Color.white);
    label.setForeground(Color.green);
    label.setHorizontalAlignment(JLabel.RIGHT);
    label.setBorder(BorderFactory.createRaisedBevelBorder());
    label.addKeyListener(this);
  }
  public JScrollPane getLabel(JLabel label, String name){
    label = new JLabel(name);
    JScrollPane scrollPane = new JScrollPane(label1);

    scrollPane.setBackground(Color.black);
    System.out.println(scrollPane.getBackground());
    return scrollPane;
  }
  private void treatLabelText(String text){
        int len = labelText.length();
        if(len <= 18)
          label1.setText(labelText);
        else
          label1.setText(labelText.substring(len - 18));
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource() instanceof JButton){
      JButton btn = (JButton)e.getSource();
      String text = btn.getText();
      String prevText = labelText;
      if(text.equals("C")){
        labelText = "";
        label1.setText("");
      }else if(text.equals("CE")){
        if(labelText.length() > 0){
          labelText = labelText.substring(0, labelText.length() - 1);
          treatLabelText(labelText);
        }
      }else{
        labelText = prevText + text;
        treatLabelText(labelText);
      }
    }
  }
  public void keyReleased(KeyEvent e){}
  public void keyPressed(KeyEvent e){}
  public void keyTyped(KeyEvent e){
  }
}
