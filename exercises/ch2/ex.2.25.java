/*
 * Solution to exercise 22-24 for the level two
*/
import javax.swing.JFrame;
class Level2Frame2{
  public static void main(String[] args){
    JFrame myWindow;
    myWindow = new JFrame("Testing Thread.sleep");
    myWindow.setSize(300, 300);
    
    myWindow.setVisible(true);
    try {Thread.sleep(500);}
    catch(Exception e) { }

    myWindow.setVisible(false);
    try {Thread.sleep(500);} 
    catch(Exception e) { }

    myWindow.setVisible(true);
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
