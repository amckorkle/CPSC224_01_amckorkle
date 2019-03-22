import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MotionParallax extends JFrame {
	Timer timer;
	Point mousePos;

	public MotionParallax(){
		timer = new Timer(600, new timerListener());
		mousePos = new Point();
		addMouseMotionListener(new MyMouseMotionListener());
		
		setTitle("Motion Parallax");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		timer.start();
		setVisible(true);


	}

    public void paint(Graphics g){
        super.paint(g);
        drawBackgroundMountain(g, .5);
        drawForegroundMountains(g, .7);
        drawSun(g, 0);  
        drawRiver(g, 1);  
    }

    public void drawSun(Graphics g, double layer){
        g.setColor(Color.YELLOW);
        g.drawOval(350, 100, 100, 100);
        g.fillOval(350, 100, 100, 100);
    }

    public void drawRiver(Graphics g, double layer){
        g.setColor(Color.BLUE);
        g.drawRect(0, 400, 500, 100);
        g.fillRect(0, 400, 500, 100);
    }

    public void drawBackgroundMountain(Graphics g, double layer){
        int xValues[] = {100, 300, 500};
        int yValues[] = {500, 200, 500};
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);

        Color randomColor = new Color(red,green,blue);

        g.setColor(randomColor);
        g.fillPolygon(xValues, yValues, 3);
    }

    public void drawForegroundMountains(Graphics g, double layer){
        int xValues[] = {-50, 130, 310, 440, 570};
        int yValues[] = {500, 150, 500, 260, 500};
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);

        Color randomColor = new Color(red,green,blue);

        g.setColor(randomColor);
        g.fillPolygon(xValues, yValues, 5);
    }

	public static void main(String[] args){
		new MotionParallax();
    }

	public Point computeParalaxPos(Point objPos, Point mousePos, double parallaxAmt){
		int x = objPos.x + (int)(parallaxAmt * (mousePos.x - objPos.x));
		int y = objPos.y + (int)(parallaxAmt * (mousePos.y - objPos.y));
		return new Point(x, y);
	}

	private class timerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			repaint();
		}
	}

	private class MyMouseMotionListener implements MouseMotionListener{
		public void mouseDragged(MouseEvent e)
        {
        }
      
        
        public void mouseMoved(MouseEvent e)
        {
			mousePos.setLocation(e.getX(), e.getY());
		}
		
	}
}