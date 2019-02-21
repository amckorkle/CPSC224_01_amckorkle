
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aylam
 */
public class GameInfoPanel extends JPanel{
    private JLabel messageLabel; 

    public GameInfoPanel(){
        
        messageLabel = new JLabel("Welcome to Tic-Tac-Toe!");
        
        setBorder(BorderFactory.createEtchedBorder());
        
        add(messageLabel);
    }
}
