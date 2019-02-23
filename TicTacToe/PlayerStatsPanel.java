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

public class PlayerStatsPanel extends JPanel{
    private JTextField player1Name;
    private JTextField wins;
    private JTextField losses;
    private JLabel nameLabel;
    private JLabel winsLabel;
    private JLabel lossesLabel;
	private JPanel player1Panel;
	private Player playerOwner;
    
    
    public PlayerStatsPanel(Player player){
		playerOwner = player;
        player1Panel = new JPanel();
        player1Panel.setLayout(new GridLayout(3, 1));
        
        nameLabel = new JLabel("Name: ");
        player1Name = new JTextField(player.getName(), 8);
        winsLabel = new JLabel("Wins: ");
        wins = new JTextField(8);
        wins.setEditable(false);
        lossesLabel = new JLabel("Losses: ");
        losses = new JTextField(8);
        losses.setEditable(false);
        
        setBorder(BorderFactory.createTitledBorder("Player 1 (X)"));
        
        player1Panel.add(nameLabel);
        player1Panel.add(player1Name);
        player1Panel.add(winsLabel);
        player1Panel.add(wins);
        player1Panel.add(lossesLabel);
        player1Panel.add(losses);
        
        add(player1Panel);
	}
	
	public void refresh(){
		wins.setText("" + playerOwner.getWins());
		losses.setText("" + playerOwner.getLosses());
		player1Name.setText(playerOwner.getName());
	}

}
