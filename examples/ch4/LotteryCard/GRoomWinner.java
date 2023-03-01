import java.awt.*;
import javax.swing.*;
class GRoomWinner {
public static void main(String[] args) {
    JFrame win;
    Container contentPane;
    Graphics g;
    LotteryCard one, two, three;
    win = new JFrame("Room Winner");
    win.setSize(300, 300);
    win.setLocation(100,100);
    win.setVisible(true);
    contentPane = win.getContentPane();
    contentPane.setBackground(Color.WHITE);
    g = contentPane.getGraphics();
    one = new LotteryCard();
    two = new LotteryCard();
    three = new LotteryCard();

    one.spin();
    two.spin();
    three.spin();
    try{Thread.sleep(500);}catch(Exception e){}
    int cardWidth = LotteryCard.WIDTH;
    one.draw(g, 10 + 0*(cardWidth+ 5), 20);
    two.draw(g, 10 + 1*(cardWidth+ 5), 20);
    three.draw(g, 10 + 2*(cardWidth+ 5), 20);
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}   
