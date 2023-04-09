package prime.gui;

import prime.generator.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeGenerator extends JFrame implements ActionListener{
  protected static final long serialVersionUID = 1L;
  private JButton genButton;
  private JTextField inputLine;
  private JTextArea textArea;
  public static void main(String[] args) {
    PrimeGenerator frame = new PrimeGenerator();
    frame.setVisible(true);
  }

  public PrimeGenerator(){
    Container parentContainer = getRootContainer();

    Container container1 = getPane();
    Container container2 = getPane();
   
    JScrollPane pane = setUpScreen();
    joinPanes(parentContainer, container1, container2, pane);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private Container getRootContainer(){
    Container parentContainer = getContentPane();
    setSize(500, 500);
    setResizable(true);
    setLocation(100, 100);
    parentContainer.setLayout(new BorderLayout());
    return parentContainer;
  }

  private Container getPane(){
    Container container = new Container();
    container.setLayout(new FlowLayout(1, 50, 20));
    return container;
  }
  public JScrollPane setUpScreen(){
    inputLine = new JTextField();
    inputLine.setColumns(15);
   
    genButton = new JButton("Generate");
    genButton.setBackground(Color.white);
    
    textArea = new JTextArea();
    textArea.setColumns(29);
    textArea.setRows(20);
    textArea.setBorder(BorderFactory.createLineBorder(Color.black));
    textArea.setEditable(false);
    JScrollPane pane = new JScrollPane(textArea);
    pane.setSize(200, 135);
    
    inputLine.addActionListener(this);
    genButton.addActionListener(this);

    return pane;
  }
  public void joinPanes(Container parent, Container child1, Container child2, JScrollPane pane){
    child1.add(inputLine);
    child1.add(genButton);
    child2.add(pane);
    parent.add(child1, BorderLayout.NORTH);
    parent.add(child2, BorderLayout.CENTER);
  }

  private void printText(int[] primes, int maxPerLine){
    int count = 0;
    for(int num: primes){
      count += 1;
      if(count % maxPerLine == 0) textArea.append(num + "\n");
      else textArea.append(num + "  ");
    }
  }
  public void actionPerformed(ActionEvent e){
    textArea.setText("");
    String text;
    int[] primes;
    if (e.getSource() instanceof JButton){
      text = inputLine.getText().strip();
      primes = Prime.first(Integer.parseInt(text));
      if(text != "") printText(primes, 15);
    }
    else{
      text = inputLine.getText().strip();
      primes = Prime.first(Integer.parseInt(text));
      if(text != "") printText(primes, 15);
    }
  }
}
