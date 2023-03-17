import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class JButtonFrame extends JFrame implements ActionListener{
  protected static final long serialVersionUID = 1L;
  private static final int FRAME_WIDTH = 300;
  private static final int FRAME_HEIGHT = 200;
  private static final int FRAME_X_ORIGIN = 150;
  private static final int FRAME_Y_ORIGIN = 250;

  private JButton cancelButton, okButton;

  public static void main(String[] args) { 
    JButtonFrame frame = new JButtonFrame();
    frame.setVisible(true);
  }
  public JButtonFrame() {
    Container contentPane = getContentPane();
    //set the frame default properties
    setTitle("Blue Background JFrame Subclass");
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setResizable(false);
    setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
    //register 'Exit upon closing' as a default close operation

    contentPane.setLayout(new FlowLayout());

    okButton = new JButton("OK");
    contentPane.add(okButton);

    cancelButton = new JButton("CANCEL");
    contentPane.add(cancelButton);

    //ButtonHandler handler = new ButtonHandler();
    cancelButton.addActionListener(this);
    okButton.addActionListener(this);
    
    changeBkColor(contentPane, Color.white);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  private void changeBkColor(Container contentPane, Color color) {
    contentPane.setBackground(color);
  }
  public void actionPerformed(ActionEvent e){
    String buttonText = e.getActionCommand();
    setTitle("You clicked " + buttonText);
  }
}
