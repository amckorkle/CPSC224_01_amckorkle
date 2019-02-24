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
    private String player1Name;
    private String player2Name;
    private GameBoard board;
    private Player player1;
    private Player player2;
    
    public buildButtonPanel(GameBoard board, Player player1, Player player2){
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;

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
                player1.reset();
                player2.reset();
            }
            
        }
    }
    
    private class NewGameButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
                player1Name = player1.getName();
                player2Name = player2.getName();
                System.out.println(player1Name);
                if(player1Name.trim().isEmpty() || player2Name.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Names are Illegal", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            else{ 
                board.enableGrid();
                board.reset();
                player1.disableNames();
                player2.disableNames();
            }
        }
    }
}
