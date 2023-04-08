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
    textArea.setEditable(false);
    container1.add(genButton);
   
    inputLine.addActionListener(this);
    genButton.addActionListener(this);

    textArea = new JTextArea();
    textArea.setColumns(29);
    textArea.setRows(30);
    textArea.setBorder(BorderFactory.createLineBorder(Color.black));
    textArea.setEditable(false);
    JScrollPane pane = new JScrollPane(textArea);
    pane.setSize(200, 135);
    container2.add(pane);

    parentContainer.add(container1, BorderLayout.NORTH);
    parentContainer.add(container2, BorderLayout.CENTER);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private boolean isPrime(int num){
    if(num == 0 || num == 1) return false;
    int i = 2;
    while(i <= Math.sqrt((double)num)){
      if(num % i == 0) return false;
      i += 1;
    }
    return true;
  }
  private int[] genPrimes(int n){
    int[] primes = new int[0];
    if(n < 1) return primes;
    primes = new int[n];
    int count = 1;
    int prime = 2;
    primes[0] = prime;
    if(n == 1){
      return primes;
    }
    prime += 1;
    while(true){
      if(isPrime(prime)){
        primes[count] = prime;
        count += 1;
        if(count == n) return primes;
      }
      prime += 2;
    }
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
      primes = genPrimes(Integer.parseInt(text));
      if(text != "") printText(primes, 15);
    }
    else{
      text = inputLine.getText().strip();
      primes = genPrimes(Integer.parseInt(text));
      if(text != "") printText(primes, 15);
    }
  }
}
