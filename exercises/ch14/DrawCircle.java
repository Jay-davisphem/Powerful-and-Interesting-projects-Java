/*
 * Write an application that draws a circle every time the mouse button is
  clicked. The position where the mouse is clicked will become the center of
  the circle. Set the radius of the circle to 100 pixels.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DrawCircle extends JFrame implements MouseListener{
  protected static final long serialVersionUID = 1L;
  protected static final int CIRCLE_RADIUS = 100;
  private static final int DOUBLE_CLICK = 2;
  Container container;

  public DrawCircle(){
    setTitle("Draw circles.");
    setSize(500, 500);
    setLocation(0, 0);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    container = getContentPane();
    addMouseListener(this);
  }
  public static void main(String[] args){
    DrawCircle circle = new DrawCircle();
    circle.setVisible(true);
  }

  private void drawCircle(int x, int y){
    System.out.println(x + ", " + (y-37));
    Graphics g = container.getGraphics();
    g.drawOval(x - CIRCLE_RADIUS/2, y - CIRCLE_RADIUS/2 - 37,  CIRCLE_RADIUS, CIRCLE_RADIUS);
  }
  public void mouseClicked(MouseEvent event){
    if (event.getClickCount() == DOUBLE_CLICK) {
      System.exit(0);
    } else {
      drawCircle(event.getX(), event.getY());
    }
  }
  public void mouseEntered (MouseEvent event){}
  public void mouseExited (MouseEvent event){}
  public void mousePressed (MouseEvent event){}
  public void mouseReleased(MouseEvent event){}
}
