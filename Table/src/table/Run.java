package table;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dmitry
 */
public class Run {

    private static boolean isLogin = false;
    private static String login = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//start();        

        JFrame jf = new Diagram(){
            public void paint(Graphics g){
                          super.paint(g);

          g.setColor(Color.BLUE); // устанавливаем текущий цвет

          g.drawLine(0,0 ,getSize().width , getSize().height);// рисуем линию через весь размер экрана

          g.setColor(new Color (128,128,128));

          g.drawOval(getSize().width/2 , getSize().height/2, 100, 50);

          g.setColor(new Color (0xFFFF00A0, true));

          g.drawPolygon(

                new Polygon(new int []{0,100,200,300}, new int []{0 , 200, 300, 100}, 4)

          );

 

          g.drawRoundRect(60 , 60 , 210 , 210 , 50 , 10);

          g.drawString("Hello From Java 2D", 50 , 50);

          g.fillRect(20 , 20 , 60 , 60);
            }
        };

        jf.setVisible(true);
    }

    public static void setIsLogin(boolean b) {
        Run.isLogin = b;
    }

    public static void setLogin(String login) {
        Run.login = login;
    }

    public static void start() {
        GUI.setLoginVisible(true);
    }
}
