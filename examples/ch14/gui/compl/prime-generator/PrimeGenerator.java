import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class PrimeGenerator extends JFrame implements ActionListener{
  protected static final long serialVersionUID = 1L;
  private JButton genButton;
  private JTextField inputLine;
  private JTextArea textArea;
  public static void main(String[] args) {
    PrimeGenerator frame = new PrimeGenerator();
    frame.setVisible(true);
  }

  public PrimeGenerator(){
    Container parentContainer = getContentPane();
    setSize(500, 500);
    setResizable(true);
    setLocation(100, 100);

    parentContainer.setLayout(new BorderLayout());
    
    Container container1 = new Container();
    Container container2 = new Container();
    container1.setLayout(new FlowLayout(1, 50, 20));
    container2.setLayout(new FlowLayout(1, 50, 20));

    inputLine = new JTextField();
    inputLine.setColumns(15);
    container1.add(inputLine);
   
    genButton = new JButton("Generate");
    genButton.setBackground(Color.white);
    container1.add(genButton);
    
    inputLine.addActionListener(this);
    genButton.addActionListener(this);

    textArea = new JTextArea();
    textArea.setColumns(29);
    textArea.setRows(8);
    textArea.setBorder(BorderFactory.createLineBorder(Color.black));
    textArea.setEditable(false);
    container2.add(textArea);

    parentContainer.add(container1, BorderLayout.NORTH);
    parentContainer.add(container2, BorderLayout.CENTER);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent e){

  }
}
