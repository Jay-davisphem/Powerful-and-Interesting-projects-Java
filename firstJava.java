/*
    Chapter 2 Sample Program: Displaying a Window
    File: Ch2Sample1.java
*/
import javax.swing.*;
class Ch2Sample1 {
    public static void main(String[] args) {
        JFrame myWindow = new JFrame("My First Java Program");
        myWindow.setSize(300, 300);
        myWindow.setVisible(true);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}
