import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MotionParallax extends JFrame {
	Timer timer;
	Point mousePos;

	public MotionParallax(){
		timer = new Timer(30, new timerListener());
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
        drawSun(g, 0.05);
        //drawBackgroundMountain(g, 0.15);
        //drawForegroundMountains(g, 0.25);
		drawBackgroundRiver(g, 0.5);
		drawFish(g, 0.65);
        drawRiver(g, 0.7);
        drawWaves(g, 0.7);
    }

    public void drawSun(Graphics g, double layer){
		g.setColor(Color.YELLOW);
		Point sunP = computeParallaxPos(new Point(350, 100), layer);
        g.fillOval(sunP.x, sunP.y, 100, 100);
    }

    public void drawRiver(Graphics g, double layer){
		g.setColor(Color.CYAN);
		Point river = computeParallaxPos(new Point(-200, 450), layer);
        g.fillRect(river.x, river.y, 1000, 1000);
    }

    public void drawBackgroundRiver(Graphics g, double layer){
		g.setColor(Color.BLUE);
		Point river = computeParallaxPos(new Point(-200, 400), layer);
        g.fillRect(river.x, river.y, 1000, 200);
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

    public void drawFish(Graphics g, double layer){
        int xValues[] = {300, 310, 300};
		int yValues[] = {420, 440, 450};

		Point fish[] = new Point[3];
		for(int i = 0; i < 3; i++){
			fish[i] = computeParallaxPos(new Point(xValues[i], yValues[i]), layer);
			xValues[i] = fish[i].x;
			yValues[i] = fish[i].y;
		}

		g.setColor(Color.RED);
		
		Point fishOval = computeParallaxPos(new Point(308, 420), layer);
        g.fillOval(fishOval.x, fishOval.y, 30, 20);
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

	public Point computeParallaxPos(Point objPos, double parallaxAmt){
		int x = objPos.x + (int)(parallaxAmt * (mousePos.x - 250));
		int y = objPos.y + (int)(parallaxAmt * (mousePos.y - 250));
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