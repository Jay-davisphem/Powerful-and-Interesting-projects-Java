import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TextHandler implements ActionListener {
  JTextField _inputLine;
  public TextHandler(JTextField inputLine){
    super();
    _inputLine = inputLine;
  }
  public void actionPerformed(ActionEvent e){
    JTextField source = (JTextField)e.getSource();
    JRootPane root = source.getRootPane();
    Frame frame = (JFrame)root.getParent();
    frame.setTitle("Wow this is working '" + _inputLine.getText() + "'");
  }
}
