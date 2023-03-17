import javax.swing.*;
import java.awt.*;
class SimpleMessage{
  public static void main(String[] args){
    JFrame jFrame = new JFrame();
    jFrame.setLocation(500, 250);
    jFrame.setSize(400, 300);
    jFrame.setVisible(true);
    Container contentPane = jFrame.getContentPane();
    contentPane.setBackground(Color.black);
    JOptionPane.showMessageDialog(jFrame, "I love Java\nEvent Driven Java");
    String input = JOptionPane.showInputDialog(jFrame, "What is your name?");
    JOptionPane.showMessageDialog(jFrame, "My name is "+input);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
