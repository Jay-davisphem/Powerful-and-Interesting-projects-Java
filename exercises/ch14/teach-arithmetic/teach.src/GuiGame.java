import teach.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GuiGame extends JFrame implements ActionListener{
  private static final String QUESTION_FORMAT = "%1$-4s %2$s %3$4s";
  private static final String COUNT_FORMAT = "Correct: %1$3s  Incorrect: %2$3s";
  private static final int DIGIT = 1;
  private ArithmeticUtil meticUtil;

  private JLabel label1;
  private JTextField inputLine;
  private JLabel label2;
  private JButton okButton;
  private JButton nextButton;
  private JButton resetButton;

  private int correctCount = 0;
  private int incorrectCount = 0;
  private int opd1, opd2, answer;
  private String op;

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
    meticUtil = new ArithmeticUtil();
    Container parentContainer = getRootContainer();
   
    Container countPane = getPane(0, 20);
    Container child1 = getPane(30, 10);
    Container child2 = getPane(10, 30);
    Container child3 = getPane(50, 10);
    Container child4 = getPane(0, 20);

    setQuestion();
    countLabel = getLabel(String.format(COUNT_FORMAT, correctCount, incorrectCount), 20, Font.PLAIN);
    label1 = getLabel(String.format(QUESTION_FORMAT, opd1, op, opd2), 25, Font.BOLD);
    JLabel equalLabel = getLabel("=", 25, Font.BOLD);
    inputLine = new JTextField();
    inputLine.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
    inputLine.setColumns(2);
    inputLine.setToolTipText("You only hava one trial per question!");

    label2 = getLabel("", 20, Font.PLAIN);


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
  public void actionPerformed(ActionEvent e){
    if(e.getSource() instanceof JButton){
      JButton btn = (JButton)e.getSource();
      String text = btn.getText();
      if(text.equals("OK")){
          okAction();
      } else if(text.equals("Next")){
        nextAction();
      }else{
        resetAction();
      }
    }else{
      okAction();
    }
  }
  private boolean isDigit(String text){
    try{
      Integer.parseInt(text);
      return true;
    }catch(Exception e){
      return false;
    }
  }
  private void okAction(){
    String text = inputLine.getText();
    if(isDigit(text)){
      verifyResult(Integer.parseInt(text));
      countLabel.setText(String.format(COUNT_FORMAT, correctCount, incorrectCount));
      nextAction();
    } else{
      label2.setText("Invalid value! Enter only digit.");
      label2.setForeground(Color.orange);
    }
    inputLine.setText("");
  }
  private void nextAction(){
    setQuestion();
    label1.setText(String.format(QUESTION_FORMAT, opd1, op, opd2));
  }
  private void resetAction(){
    resetQuestion();
    countLabel.setText(String.format(COUNT_FORMAT, correctCount, incorrectCount));
    inputLine.setText("");
    label2.setText("");
    nextAction();
  }
  private void setQuestion(){
    opd1 = meticUtil.getRandomOpd(DIGIT);
    opd2 = meticUtil.getRandomOpd(DIGIT);
    op = meticUtil.getRandomOp();
    if(op.equals(meticUtil.DIV) && (opd1 % opd2 != 0))
      setQuestion();
  }
  private void resetQuestion(){
    correctCount = incorrectCount = 0;
  }
  private void verifyResult(int intTxt){
      if(meticUtil.check(opd1, opd2, op, intTxt)){
        label2.setText("Correct!");
        label2.setForeground(Color.green);
        correctCount += 1;
      } else{
        label2.setText("Incorrect!");
        label2.setForeground(Color.red);
        incorrectCount += 1;
      }
  }
}
