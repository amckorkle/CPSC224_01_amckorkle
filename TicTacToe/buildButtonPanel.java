/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aylam
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class buildButtonPanel extends JPanel {
    private JButton newGame;
    private JButton reset;
    private JButton exit;
    private PlayerStatsPanel playerName;
    private GameBoard board;
    private Player player;
    
    public buildButtonPanel(GameBoard board, Player player){
        this.board = board;
        this.player = player;
        
        exit = new JButton("Exit");
        exit.addActionListener(new ExitButtonListener());
        
        reset = new JButton("Reset");
        reset.addActionListener(new ResetButtonListener());
        
        newGame = new JButton("New Game");
        newGame.addActionListener(new NewGameButtonListener());
        
        add(newGame);
        add(reset);
        add(exit);
        
    }
    
    private class ExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    private class ResetButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int userChoice = JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?", 
                    null, JOptionPane.YES_NO_OPTION);
            if(userChoice == JOptionPane.YES_OPTION){
                board.reset();
                player.reset();
            }
            
        }
    }
    
    private class NewGameButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(PlayerName.getName() == null){
                JOptionPane.showMessageDialog(null, "Names are Illegal", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
            //else{ 
                
            //}
        }
    }
}
