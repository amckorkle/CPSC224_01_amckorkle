
/**
 * Assignment 3
 * Due Date: 2/22/19
 * Authors: Ayla McKorkle and Kasey Davis
 * Github: amckorkle
 */
import java.awt.*;
import javax.swing.*;
public class GameInfoPanel extends JPanel{
    private JLabel messageLabel; 

    /*
    * consturctor
    */
    public GameInfoPanel(){
        
        messageLabel = new JLabel("Welcome to Tic-Tac-Toe!");
        
        setBorder(BorderFactory.createEtchedBorder());
        
        add(messageLabel);
	}
	
    
   /**
      setInforPanelText method
      @param text passes in the message to be displayed on the bottom of the GUI
   */
	public void setInfoPanelText(String text){
		messageLabel.setText(text);
	}
}
