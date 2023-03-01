import java.util.Random;
import java.awt.*;
class LotteryCard {
  // Data Members
  //the largest number on a card
  private static final int MAX_NUMBER = 15;
  //the smallest number on a card
  private static final int MIN_NUMBER = 10;
  //to represent a card before drawing
  private static final int NO_NUMBER = 0;
  //the 'largest' color for a card
  private static final int MAX_COLOR = 3;
  //the 'smallest' color for a card
  private static final int MIN_COLOR = 1;
  //to represent a card before drawing
  private static final int NO_COLOR = 0;
  //selected number on this card
  private int number;
  //selected color of this card
  private int color;
  //random number generator
  private Random random;
  //width of this card for drawing
  public static final int WIDTH = 80;
  //height of this card for drawing
  public static final int HEIGHT = 100;
  //Constructor
  public LotteryCard( ) {
    random = new Random( );
    number = NO_NUMBER;
    color = NO_COLOR;
  }
  //spin the card
  public void spin( ) {
    number = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    color = random.nextInt(MAX_COLOR - MIN_COLOR + 1) + MIN_COLOR;
  }
  //Returns the number on this card
  public int getNumber( ) {
    return number;
  }
  //Returns the color of this card
  public int getColor( ) {
    return color;
  }
  public void draw(Graphics g, int xOrigin, int yOrigin) {
    switch (color) {
      case 1: g.setColor(Color.RED);
              break;
      case 2: g.setColor(Color.GREEN);
              break;
      case 3: g.setColor(Color.BLUE);
              break;
    }
    
    g.fillRect(xOrigin, yOrigin, WIDTH, HEIGHT);
    g.setColor(Color.WHITE); //draw text in white
    g.drawString( "" + number, xOrigin + WIDTH/4, yOrigin + HEIGHT/2);
  }
}
