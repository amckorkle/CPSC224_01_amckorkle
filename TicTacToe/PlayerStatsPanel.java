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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;

public class PlayerStatsPanel extends JPanel{
    JTextField player1Name;
    private JTextField wins;
    private JTextField losses;
    private JLabel nameLabel;
    private JLabel winsLabel;
    private JLabel lossesLabel;
	private JPanel player1Panel;
	private Player playerOwner;
    
    
    public PlayerStatsPanel(Player player, String panelHeader){
		playerOwner = player;
        player1Panel = new JPanel();
        player1Panel.setLayout(new GridLayout(3, 1));
        
        nameLabel = new JLabel("Name: ");
		player1Name = new JTextField(player.getName(), 8);
		player1Name.getDocument().addDocumentListener(new TextChangeListener());
        winsLabel = new JLabel("Wins: ");
        wins = new JTextField(8);
        wins.setEditable(false);
        lossesLabel = new JLabel("Losses: ");
        losses = new JTextField(8);
        losses.setEditable(false);
        
        setBorder(BorderFactory.createTitledBorder(panelHeader));
        
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
	}

	private class TextChangeListener implements DocumentListener{
		public void changedUpdate(DocumentEvent e){
			playerOwner.setName(player1Name.getText());
		}

		public void removeUpdate(DocumentEvent e){
			playerOwner.setName(player1Name.getText());
			
		}

		public void insertUpdate(DocumentEvent e){
			playerOwner.setName(player1Name.getText());
			
		}
	}
}
