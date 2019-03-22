import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MotionParallax extends JFrame {
	public MotionParallax(){
		setTitle("Motion Parallax");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args){
		new MotionParallax();
	}
}