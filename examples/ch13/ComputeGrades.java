//---------------------- STEP 1 ----------------------//
class ComputeGrades extends MainWindow {
  private static final int DEFAULT_SIZE = 25;
  private OutputBox outputBox;
  private Student[] roster;
  public ComputeGrades() {
    this (DEFAULT_SIZE);
  }
  public ComputeGrades(int arraySize) {
    super();
    // an explicit call to the superclass constructor
    outputBox= new OutputBox(this);
    roster= new Student[arraySize];
  }
  //------------------------------
  // Main
  //------------------------------
  public static void main(String[] args) {
    ComputeGrades gradeComputer = new ComputeGrades();
    gradeComputer.processData();
  }
  public void processData() {
    this.setVisible(true);
    outputBox.setVisible(true);
    boolean success = readData();
    if (success) {
      computeGrade();
      printResult();
    } else {
      outputBox.println("File Input Error");
    }
  }
  private void computeGrade() {
    outputBox.println("Inside computeGrade");
    //TEMP
  }
  private void printResult() {
    outputBox.println("Inside printResult");
  }
  private boolean readData() {
    outputBox.pristln("Inside readData");
  return true;
  //TEMP
  }
}
