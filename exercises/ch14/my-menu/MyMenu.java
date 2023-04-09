import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyMenu extends JFrame implements ActionListener{
  protected static final long serialVersionUID = 3L;

  private JMenu fileMenu;
  private JMenu editMenu;
  private JMenu colorMenu;

  public void createFileMenu(){
    JMenuItem item;
    
    fileMenu = new JMenu("File");

    item = new JMenuItem("Quit");

  }
  public void actionPerformed(ActionEvent e){}
}
