import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MotionParallax extends JFrame {
	Timer timer;
	Point mousePos;
    Color randomColor1;
    Color randomColor2;

	public MotionParallax(){
        randomColor1 = generateRandomColor();
        randomColor2 = generateRandomColor();
		timer = new Timer(600, new timerListener());
		mousePos = new Point();
		addMouseMotionListener(new MyMouseMotionListener());
		getContentPane().setBackground(Color.CYAN);
		setTitle("Motion Parallax");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		timer.start();
		setVisible(true);


	}

    public void paint(Graphics g){
        super.paint(g);
        drawBackgroundRiver(g, 0);
        drawBackgroundMountain(g, .5, randomColor2);
        drawForegroundMountains(g, .7, randomColor1);
        drawSun(g, 0);  
        drawRiver(g, 0.9);
        drawWaves(g, 1);
        drawFish(g, 1);
    }

    public Color generateRandomColor(){
        Color randomColor;
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);
        randomColor = new Color(red,green,blue);
        return randomColor;
    }

    public void drawSun(Graphics g, double layer){
        g.setColor(Color.YELLOW);
        g.fillOval(350, 100, 100, 100);
    }

    public void drawRiver(Graphics g, double layer){
        g.setColor(Color.BLUE);
        g.fillRect(0, 400, 500, 100);
    }

    public void drawBackgroundRiver(Graphics g, double layer){
        g.setColor(Color.CYAN);
        g.fillRect(0, 400, 500, 100);
    }

    public void drawBackgroundMountain(Graphics g, double layer, Color randomColor2){
        int xValues[] = {100, 300, 500};
        int yValues[] = {500, 200, 500};
        g.setColor(randomColor2);
        g.fillPolygon(xValues, yValues, 3);
    }

    public void drawForegroundMountains(Graphics g, double layer, Color randomColor1){
        int xValues[] = {-50, 130, 310, 440, 570};
        int yValues[] = {500, 150, 500, 260, 500};
        g.setColor(randomColor1);
        g.fillPolygon(xValues, yValues, 5);
    }

    public void drawFish(Graphics g, double layer){
        int xValues[] = {300, 310, 300};
        int yValues[] = {450, 460, 470};
        g.setColor(Color.RED);
        g.fillOval(308, 450, 30, 20);
        g.fillPolygon(xValues, yValues, 3);


    }

    public void drawWaves(Graphics g, double layer){
        int x = 20;
        int y = 420;
        g.setColor(Color.BLACK);
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 5; i++){
                g.drawArc(x, y, 10, 10, 360, 180);
                x+=10;
                g.drawArc(x, y, 10, 10, 180, 180);
                x+=10;
            }
            x+=70;
            y+=20;
        }
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