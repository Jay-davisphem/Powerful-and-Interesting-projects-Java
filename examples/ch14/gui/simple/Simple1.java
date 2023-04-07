import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class JButtonFrame extends JFrame implements ActionListener{
  protected static final long serialVersionUID = 1L;
  private static final int FRAME_WIDTH = 250;
  private static final int FRAME_HEIGHT = 400;
  private static final int FRAME_X_ORIGIN = 150;
  private static final int FRAME_Y_ORIGIN = 250;
  private static final String NEWLINE = System.getProperty("line.separator");
  private JButton clearButton, addButton;
  private JTextField inputLine;

  private JLabel prompt;
  private JTextArea textArea;
  public static void main(String[] args) { 
    JButtonFrame frame = new JButtonFrame();
    frame.setVisible(true);
  }
  public JButtonFrame() {
    Container contentPane = getContentPane();
    //set the frame default properties
    setTitle("Blue Background JFrame Subclass");
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setResizable(true);
    setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
    //register 'Exit upon closing' as a default close operation

    contentPane.setLayout(new FlowLayout());


    prompt = new JLabel("Please enter your name");
    prompt.setSize(150, 25);
    contentPane.add(prompt);


    textArea = new JTextArea();
    textArea.setColumns(22);
    textArea.setRows(8);
    //textArea.setEditable(false);
    JScrollPane scrollText = new JScrollPane(textArea);
    scrollText.setSize(200, 135);
    scrollText.setBorder(BorderFactory.createEtchedBorder(10, Color.blue, Color.black));
    contentPane.add(scrollText); 


    inputLine = new JTextField();
    inputLine.setColumns(22);
    add(inputLine);
    inputLine.addActionListener(this);
    // OR
    //TextHandler tHandler = new TextHandler(inputLine);
    //inputLine.addActionListener(this/* tHandler */);


    addButton = new JButton("ADD");
    addButton.setBackground(Color.green);
    addButton.setForeground(Color.white);
    contentPane.add(addButton);
    clearButton = new JButton("CLEAR");
    clearButton.setBackground(Color.red);
    clearButton.setForeground(Color.white);
    contentPane.add(clearButton);
    contentPane.add(clearButton);

    //ButtonHandler handler = new ButtonHandler();
    clearButton.addActionListener(this);
    addButton.addActionListener(this);
    
    changeBkColor(contentPane, Color.white);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    

  }
  private void changeBkColor(Container contentPane, Color color) {
    contentPane.setBackground(color);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource() instanceof JButton){
      JButton clkBtn =  (JButton)e.getSource();
      if(clkBtn == addButton) addText(inputLine.getText());
      else clearText();
    } else{
      addText(inputLine.getText());
    }
  }
  private void addText(String newline){
    if(newline.strip() == "") return;
    textArea.append(newline + NEWLINE);
    inputLine.setText("");
  }
  private void clearText(){
    textArea.setText("");
    inputLine.setText("");
  }
}
