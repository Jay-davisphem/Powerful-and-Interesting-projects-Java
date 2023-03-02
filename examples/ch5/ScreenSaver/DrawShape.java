import java.awt.*;
class DrawShape{
  private DrawingBoard canvas;

  public DrawShape(){
    canvas = new DrawingBoard();
  }
  public void start(){
    for(int i = 0; i < 3; i++){
      DrawableShape shape = new DrawableShape();
      shape.setCenterPoint(new Point(250 + i*250, 300));
      cavas.addShape(shape);
    }
    
    canvas.setMovement(DrawingBoard.Movement.SMOOTH);
    canvas.setVisible(true);
    canvas.start();
  }
  public static void main(String[] args){
    DrawShape screensaver = new DrawShape();
    screensaver.start();
  }
}
