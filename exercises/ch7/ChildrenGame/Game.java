import fracs.*;
import java.util.*;
class Game{
  private static int TIME_LIMIT = 30000; // 30 seconds
  private static int QUESTIONS_COUNT = 2;
  private static final int ANS_LEN_MIN = 3;
  private static final int ANS_LEN_MAX = 9;
  private static Scanner scan;
  private static enum Response {YES, NO};
  
  // Operations supported
  private static enum OP {ADD, SUB, DIV, MUL};
  private OP ops;
  private static Random random;
  private Fraction opd1, opd2, userAnswer, realAnswer;
  
  private int totalPoints = 0;
  private int correctAnsU = 0;
  private int correctAnsO = 0;
  private int wrongAnsU = 0;
  private int wrongAnsO = 0;
  
  public Game(){
    scan = new Scanner(System.in);
    random  = new Random();
  }
  private void resetValues(){
    totalPoints = 0;
    correctAnsU = 0;
    correctAnsO = 0;
    wrongAnsU = 0;
    wrongAnsO = 0;
  }
  private int getRandomInt(){
    return random.nextInt(2) + 1;
  }

  private Fraction getRandomFraction(){
    return new Fraction(getRandomInt(), getRandomInt());
  }
  private OP getRandomOp(){
    int max = OP.values().length;
    int intOp = random.nextInt(max) + 1;
    if(intOp == 1)
      return OP.ADD;
    else if(intOp == 2)
      return OP.SUB;
    else if(intOp == 3)
      return OP.DIV;
    else
      return OP.MUL;
  }
  private void setOps(OP tOp){
    ops = tOp;
  }
  private void setQuestion(){
    opd1 = getRandomFraction();
    opd2 = getRandomFraction();
  }
  private void askQuestion(int qnum){
    setQuestion();
    setOps(getRandomOp());
    display(qnum + ". What is " + opd1.toString() + getOpsStr() + opd2.toString() + "?\n");
  }
  private String getOpsStr(){
    switch(ops){
      case ADD:
        return " + ";
      case SUB:
        return " - ";
      case DIV:
        return " / ";
      default:
        return " * ";
    }
  }
  private Fraction calculate(){
    switch(ops){
      case ADD:
        return opd1.add(opd2);
      case SUB:
        return opd1.subtract(opd2);
      case DIV:
        return opd1.divide(opd2);
      default:
        return opd1.multiply(opd2);

    }
  }
  private void setRealAnswer(){
    realAnswer = calculate();
  }
  private static boolean isInt(String s){
    try{
      Integer.parseInt(s);
      return true;
    }catch (NumberFormatException e){
      return false;
    }
  }
  private boolean isAnswerValid(String txt){
    int strLen = txt.length();
    
    if(isInt(txt))
      return true;
    
    if(strLen < ANS_LEN_MIN || strLen > ANS_LEN_MAX || !txt.contains("/") || txt.endsWith("/") || txt.startsWith("/"))
      return false;
    
    String[] nums = txt.split("/");
    if(!isInt(nums[0]) || !isInt(nums[1]))
      return false;
    
    return true;
  }
  private void setUserAnswer(){
    String ansStr = readStr("What is your anwser? ").replaceAll(" ", "");
    int num, dem;
    if(isInt(ansStr)){
      num = Integer.parseInt(ansStr);
      dem = 1;
      userAnswer = new Fraction(num, dem);
    }else if (isAnswerValid(ansStr)){
      num = Integer.parseInt(ansStr.substring(0, ansStr.indexOf("/")));
      dem = Integer.parseInt(ansStr.substring(ansStr.indexOf("/") + 1));
      userAnswer = new Fraction(num, dem);
    }else{
      display("Invalid Input type!\n");
      setUserAnswer();
    }
  }
  private boolean isCorrect(){
    return realAnswer.equals(userAnswer);
  }
  private String readStr(String prompt){
    display(prompt);
    return scan.next();
  }

  private long timedQAndA(int index){
    Date startTime = new Date();
    handleOneQAndA(index);
    Date endTime = new Date();
    return endTime.getTime() - startTime.getTime();
  }
  private void handleOneQAndA(int i){
    askQuestion(i);
    setRealAnswer();
    setUserAnswer();
  }
  private int getPoint(long time, boolean correct){
    if(correct && time <= TIME_LIMIT){
      correctAnsU++;
      return 10;
    }else if(correct){
      correctAnsO++;
      return 6;
    }else if(!correct && time <= TIME_LIMIT){
      wrongAnsU++;
      return 3;
    }else{
      wrongAnsO++;
      return 0;
    }
  }
  private void setUpQuestionsAndAnswers(){
    for(int i = 1; i <= QUESTIONS_COUNT; i++){
      long time = timedQAndA(i);
      boolean correct = isCorrect();
      totalPoints += getPoint(time, correct);
    }
  }
  private void display(String text){
    System.out.print(text);
  }

  private Response prompt(String question){
    String input;
    display(question + "  (Yes - y|Y; No - n|N): ");
    input = scan.next().toUpperCase();
    switch(input){
      case "N", "NO":
        return Response.NO;
      case "Y", "YES":
        return Response.YES;
      default:
        display("You entered a wrong input\n");
        return prompt(question);
    }
  }

  private boolean isContinue(){
    Response response = prompt("Do you want to go again?");
    return response == Response.YES;
  }
  private int readInt(String prompt){
      display(prompt);
      return scan.nextInt();
  }
  private void displayResults(){
    display("\n---------------------------------------------------\n");
    display("                     Under            Over\n");
    display("                     Time Limit       Time Limet\n");
    display("-----------------------------------------------------");

    display("\nCorrect Answer           "+correctAnsU+"               "+correctAnsO);
    display("\nWrong Answer             "+wrongAnsU+"               "+wrongAnsO);

    display("\n---------------------------------------------------\n");
    display("---------------------------------------------------\n");
    display("TOTAL POINTS: " + totalPoints + " (" + correctAnsU*10 + " + " + correctAnsO*6 + " + " + wrongAnsU*3 + " + " + wrongAnsO*0 + ")\n");
    display("-----------------------------------------------------\n");
    display("---------------------------------------------------\n");
  }
  private void setUp(){
    do{
      int questionsCount = 0, durationPerquesion = 0;
      if(QUESTIONS_COUNT == 0)
        questionsCount =  readInt("How many questions? ");
      if(TIME_LIMIT == 0)
        durationPerquesion = readInt("Duration per/question? ");

      display("Question count: " + QUESTIONS_COUNT  + "\nTime: " + TIME_LIMIT + '\n');
      setUpQuestionsAndAnswers();


      displayResults();


      display("\n");
      resetValues();
    } while(isContinue());
  }
  public void start(){
    setUp();
  }
}
