import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

	public static void main(String[] args){
		new MotionParallax();
	}

    public void paint(Graphics g){
		super.paint(g);
        g.drawOval(250, 250, 20, 20);
	}
	
	public Point computeParalaxPos(Point objPos, Point mousePos, double parallaxAmt){
		int x = objX + (int)(parallaxAmt * (mousePos.x - objPos.x));
		int y = objY + (int)(parallaxAmt * (mousePos.Y - objPos.y));
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