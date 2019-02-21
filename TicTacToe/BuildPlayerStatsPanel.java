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

public class BuildPlayerStatsPanel extends JPanel{
    private JTextField player1Name;
    private JTextField player2Name;
    private JTextField wins;
    private JTextField losses;
    
    
    public BuildPlayerStatsPanel(){
        setLayout(new GridLayout(3, 1));
        

        player1Name = new JTextField(8);
        wins = new JTextField(8);
        losses = new JTextField(8);
        
        setBorder(BorderFactory.createTitledBorder("Player 1 (X)"));

      add(player1Name);
      add(wins);
      add(losses);
  
        
    }
}
