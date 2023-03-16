/*
  Chapter 9 Sample Program:
  Extract the words in a given sentence and
  print them, using one line per word.
  File: ExtractWords.java
*/
import java.util.*;
class Ch9ExtractWords {
  private static final char BLANK = ' ';
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter(System.getProperty("line.separator"));
    int index, numberOfCharacters, beginIdx, endIdx;
    String word, sentence;
    System.out.print("Input: ");
    sentence = scanner.next( );
    numberOfCharacters = sentence.length();
    index = 0;

    if(sentence.matches("[a-z&&^a^b]"))
      System.out.println("Confirm man");
    while (index < numberOfCharacters) {
      //ignore leading blank spaces
      while (index < numberOfCharacters &&
        sentence.charAt(index) == BLANK) {
        index++;
      }
    
      beginIdx = index;
      //now locate the end of the word
    
      while (index < numberOfCharacters &&
        sentence.charAt(index) != BLANK) {
        index++;
      }

      endIdx = index;
      if (beginIdx != endIdx) {
        //another word is found, extract it from the
        //sentence and print it out
        word = sentence.substring( beginIdx, endIdx );
        System.out.println(word);
      }
    }
  }
}
