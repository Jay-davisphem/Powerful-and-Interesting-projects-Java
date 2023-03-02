import java.awt.*;

class DrawableShape{
  private Point centerPoint;

  public DrawableShape(){
    centerPoint = null;
  }
  public void draw(Graphics g){
    g.setColor(Color.blue);
    g.fillOval(centerPoint.x-100, centerPoint.y-100, 200, 200);
  }
  public  Point getCenterPoint(){
    return centerPoint;
  }
  public Dimension getDimention(){
    return new Dimension(300, 400);
  }
  public void setCenterPoint(Point point){
    centerPoint = point;
  }
}
