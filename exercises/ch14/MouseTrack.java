import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class Ch14TrackMouseFrame extends JFrame implements MouseListener {
  protected static final long serialVersionUID = 0L;
  private static final int FRAME_WIDTH = 450;
  private static final int FRAME_HEIGHT = 300;
  private static final int FRAME_X_ORIGIN = 150;
  private static final int FRAME_Y_ORIGIN = 250;
  private static final int DOUBLE_CLICK = 2;

  public static void main(String[] args) {
    Ch14TrackMouseFrame frame = new Ch14TrackMouseFrame();
    frame.setVisible(true);
  }
  public Ch14TrackMouseFrame() {
    //set frame properties
    setTitle("TrackMouseFrame");
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setResizable(true);
    setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //register self as a mouse event listener
    addMouseListener(this);
  }
  public void mouseClicked(MouseEvent event) {
    if (event.getClickCount() == DOUBLE_CLICK) {
      System.exit(0);
  } else {
    int x, y;
    x = event.getX(); //get the x and y coordinates of
    y = event.getY(); //the mouse click point
    System.out.println("[" + x + "," + y + "]");
    }
  }
  public void mouseEntered (MouseEvent event) { 
    System.out.println("Entered");
  }
  public void mouseExited (MouseEvent event) { 
    System.out.println("Exited");
  }
  public void mousePressed (MouseEvent event) {
    System.out.println("Down");
  }
  public void mouseReleased(MouseEvent event) {
    System.out.println("Up");
  }
}
