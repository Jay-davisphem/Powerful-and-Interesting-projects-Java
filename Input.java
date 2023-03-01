/*
    Chapter 2 Sample Program:
    Reads a person's name and displays a greeting.
    File: Input.java
*/
import java.util.*;
class Ch2Greetings {
    public static void main(String[] args) {
        String fullname;
        Scanner scanner = new Scanner(System.in);

        // set line separator of scanner to Enter to \n for linux and \r\n for windows
        String lineSeparator = System.getProperty("line.separator");
        scanner.useDelimiter(lineSeparator);

        System.out.print ("What is your name? ");
        fullname = scanner.next( ); 
        System.out.println("Hi, " + fullname + ". Nice to meet you.");
    }
}
