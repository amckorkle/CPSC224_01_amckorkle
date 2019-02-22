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

public class BuildPlayer2StatsPanel extends JPanel{
    private JTextField player1Name;
    private JTextField wins;
    private JTextField losses;
    private JLabel nameLabel;
    private JLabel winsLabel;
    private JLabel lossesLabel;
    private JPanel player2Panel;
    
    
    public BuildPlayer2StatsPanel(){
        
        player2Panel = new JPanel();
        player2Panel.setLayout(new GridLayout(3, 1));
        
        nameLabel = new JLabel("Name: ");
        player1Name = new JTextField("Player 2", 8);
        winsLabel = new JLabel("Wins: ");
        wins = new JTextField(8);
        wins.setEditable(false);
        lossesLabel = new JLabel("Losses: ");
        losses = new JTextField(8);
        losses.setEditable(false);

        setBorder(BorderFactory.createTitledBorder("Player 2 (O)"));
        
        player2Panel.add(nameLabel);
        player2Panel.add(player1Name);
        player2Panel.add(winsLabel);
        player2Panel.add(wins);
        player2Panel.add(lossesLabel);
        player2Panel.add(losses);
        
        add(player2Panel);
    }
}
