import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ButtonHandler implements ActionListener {
  public ButtonHandler(){
  }
  public void actionPerformed(ActionEvent e){
    JButton clickedButton = (JButton) e.getSource();
    JRootPane rootPane = clickedButton.getRootPane();
    Frame frame = (JFrame) rootPane.getParent();
    String buttonText = clickedButton.getText();
    frame.setTitle("You clicked " + buttonText);
  }
}
