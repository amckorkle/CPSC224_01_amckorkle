/*
Assignment 4
due date: 3/25/19
names: Ayla McKorkle and Kasey Davis
github: amckorkle
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;

public class MotionParallax extends JFrame {
	Timer timer;
	Point mousePos;
	Point fishPos;
    Color randomColor1;
    Color randomColor2;
    boolean areSunglassesOn = false;

	public MotionParallax(){
		// Create a 60ms timer
		timer = new Timer(60, new timerListener());

		// Starting colors for the mountains
        randomColor1 = generateRandomColor();
        randomColor2 = generateRandomColor();

		mousePos = new Point();
		fishPos = new Point();

        addMouseListener(new MyMouseListener());
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

		// the second parameter indicates the portion of the mouse's movement that
		//   should reflected by the object in question
        drawSun(g, 0.05);
        drawBackgroundMountain(g, 0.15, randomColor2);
        drawForegroundMountains(g, 0.25, randomColor1);
		drawBackgroundRiver(g, 0.5);
		drawFish(g, 0.65);
        drawRiver(g, 0.7);
        drawWaves(g, 0.5);
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
		Point sunP = computeParallaxPos(new Point(350, 100), layer);
		g.fillOval(sunP.x, sunP.y, 100, 100);
		
		if(areSunglassesOn){
			drawSunglasses(g, layer + 0.02);
		}
    }

    public void drawRiver(Graphics g, double layer){
		g.setColor(Color.BLUE);
		Point river = computeParallaxPos(new Point(-200, 450), layer);
        g.fillRect(river.x, river.y, 1000, 1000);
    }

    public void drawBackgroundRiver(Graphics g, double layer){
		g.setColor(new Color(0, 0, 210));
		Point river = computeParallaxPos(new Point(-200, 400), layer);
        g.fillRect(river.x, river.y, 1000, 200);
	}

    public void drawBackgroundMountain(Graphics g, double layer, Color randomColor2){
        int xValues[] = {100, 300, 500};
		int yValues[] = {500, 200, 500};

		Point mt = new Point();
		for(int i = 0; i < xValues.length; i++){
			mt = computeParallaxPos(new Point(xValues[i], yValues[i]), layer);
			xValues[i] = mt.x;
			yValues[i] = mt.y;
		}

        g.setColor(randomColor2);
        g.fillPolygon(xValues, yValues, 3);
    }

    public void drawForegroundMountains(Graphics g, double layer, Color randomColor1){
        int xValues[] = {-50, 130, 310, 440, 570};
		int yValues[] = {500, 150, 500, 260, 500};
		
		Point mt = new Point();
		for(int i = 0; i < xValues.length; i++){
			mt = computeParallaxPos(new Point(xValues[i], yValues[i]), layer);
			xValues[i] = mt.x;
			yValues[i] = mt.y;
		}

        g.setColor(randomColor1);
        g.fillPolygon(xValues, yValues, 5);
    }

    public void drawFish(Graphics g, double layer){
		// At each time step, the fish moves a constant amount in the x direction
		//   and a varying direction in the y
		fishPos.x = (fishPos.x + 10) % 1000;
		fishPos.y = (int)(10 * Math.sin(fishPos.x / 10));

        int xValues[] = {fishPos.x - 200, fishPos.x -190, fishPos.x -200};
		int yValues[] = {fishPos.y + 430, fishPos.y + 440, fishPos.y + 450};

		Point fish[] = new Point[3];
		for(int i = 0; i < 3; i++){
			fish[i] = computeParallaxPos(new Point(xValues[i], yValues[i]), layer);
			xValues[i] = fish[i].x;
			yValues[i] = fish[i].y;
		}

		g.setColor(Color.RED);
		
		Point fishOval = computeParallaxPos(new Point(fishPos.x - 192, fishPos.y + 430), layer);
        g.fillOval(fishOval.x, fishOval.y, 30, 20);

        g.fillPolygon(xValues, yValues, 3);


    }

    public void drawWaves(Graphics g, double layer){
        int x = 20;
        int y = 420;
        g.setColor(Color.WHITE);
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 5; i++){

				Point waveParallax = computeParallaxPos(new Point(x, y), layer);
                g.drawArc(waveParallax.x, waveParallax.y, 10, 10, 360, 180);
				x+=10;

			  	waveParallax = computeParallaxPos(new Point(x, y), layer);
                g.drawArc(waveParallax.x, waveParallax.y, 10, 10, 180, 180);
                x+=10;
			}

			// these set where the next wave should be and alter the amount of parallax
            x+=70;
			y+=20;
			layer += 0.10;
        }
    }

    public void drawSunglasses(Graphics g, double layer){
        int xValues[] = {345, 455, 450, 430, 410, 400, 390, 370, 350};
		int yValues[] = {140, 140, 160, 170, 160, 142, 160, 170, 160};
		
		Point sunglasses = new Point();
		for(int i = 0; i < xValues.length; i++){
			sunglasses = computeParallaxPos(new Point(xValues[i], yValues[i]), layer);
			xValues[i] = sunglasses.x;
			yValues[i] = sunglasses.y;
		}

        g.setColor(Color.BLACK);
        g.fillPolygon(xValues, yValues, 9);
	}
	
	public Point computeParallaxPos(Point objPos, double parallaxAmt){
		int x = objPos.x + (int)(parallaxAmt * (mousePos.x - 250));
		int y = objPos.y + (int)(parallaxAmt * (mousePos.y - 250));
		return new Point(x, y);
	}

	public static void main(String[] args){
		new MotionParallax();
    }

	

	private class timerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// the screen is repainted every 60ms
			repaint();
		}
	}

    private class MyMouseListener implements MouseListener{
        public void mousePressed(MouseEvent e){
		}
		
        public void mouseClicked(MouseEvent e){
			//every time the mouse is clicked, the mountains get a new color
            randomColor1 = generateRandomColor();
            randomColor2 = generateRandomColor();
		}
		
        public void mouseReleased(MouseEvent e){
			// when the mouse is released the sun gets/loses its sunglasses
            areSunglassesOn = !areSunglassesOn;
		}
		
        public void mouseEntered(MouseEvent e){
			// unpauses the screen when the mouse returns to the screen
            timer.start();
		}
		
        public void mouseExited(MouseEvent e){
			// pauses the screen when the mouse leaves the screen
            timer.stop();
        }
    }

	private class MyMouseMotionListener implements MouseMotionListener{
		public void mouseDragged(MouseEvent e)
        {
        }
      
        
        public void mouseMoved(MouseEvent e)
        {
			// always reset the mouse location when the mosue moves
			mousePos.setLocation(e.getX(), e.getY());
		}
		
	}
}