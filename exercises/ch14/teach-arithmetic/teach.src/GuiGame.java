import fracs.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GuiGame extends JFrame implements ActionListener{
  private JLabel label1;
  private JTextField inputLine;
  private JLabel label2;
  private JButton okButton;
  private JButton nextButton;
  private JButton resetButton;
  private int correctCount = 0;
  private int incorrectCount = 0;
  private JLabel countLabel;
  public static void main(String[] args){
    GuiGame game = new GuiGame();
    game.setVisible(true);
  }

  private JButton getButton(String name){
    JButton button = new JButton(name);
    button.setBackground(Color.white);
    button.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
    return button;
  }
  private JLabel getLabel(String name, int size, int boldness){
    JLabel label = new JLabel(name);
    label.setFont (new Font(Font.SERIF, boldness, size));
    return label;
  }
  public GuiGame(){
    Container parentContainer = getRootContainer();
   
    Container countPane = getPane(0, 20);
    Container child1 = getPane(30, 10);
    Container child2 = getPane(10, 30);
    Container child3 = getPane(50, 10);
    Container child4 = getPane(0, 20);

    countLabel = getLabel(String.format("Correct: %1$s  Incorrect: %2$s", correctCount, incorrectCount), 20, Font.PLAIN);
    label1 = getLabel("8  x  7", 25, Font.BOLD);
    JLabel equalLabel = getLabel("=", 25, Font.BOLD);
    inputLine = new JTextField();
    inputLine.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
    inputLine.setColumns(2);

    label2 = getLabel("Correct", 20, Font.PLAIN);


    okButton = getButton("OK");
    nextButton = getButton("Next");
    resetButton = getButton("Reset");

    inputLine.addActionListener(this);
    okButton.addActionListener(this);
    nextButton.addActionListener(this);
    resetButton.addActionListener(this);

    countPane.add(countLabel);
    child1.add(label1);
    child1.add(equalLabel);
    child1.add(inputLine);
    child2.add(label2);
    child3.add(okButton);
    child3.add(nextButton);
    child4.add(resetButton);

    parentContainer.add(countPane);
    parentContainer.add(child1);//, BorderLayout.NORTH);
    parentContainer.add(child2);//, BorderLayout.CENTER);
    parentContainer.add(child3); //, BorderLayout.SOUTH);
    parentContainer.add(child4);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }


  private Container getRootContainer(){
    Container parentContainer = getContentPane();
    setSize(300, 400);
    setResizable(false);
    setLocation(100, 100);
    parentContainer.setLayout(new FlowLayout());
    return parentContainer;
  }

  private Container getPane(int margX, int margY){
    Container container = new Container();
    container.setLayout(new FlowLayout(1, margX, margY));
    return container;
  }
  public void actionPerformed(ActionEvent e){}
}
