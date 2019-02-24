
/**
 * Assignment 3
 * Due Date: 2/22/19
 * Authors: Ayla McKorkle and Kasey Davis
 * Github: amckorkle
 */

import javax.swing.*;

public class Player {
	private ImageIcon symbol;
	private int wins = 0;
	private int losses = 0;
	private String name;
	private PlayerStatsPanel panel;
	private String initialName;

	/*
    * consturctor
    */
	public Player(String path, String defaultName) {
		symbol = new ImageIcon(path);
		name = defaultName;
		initialName = defaultName;
	}

	
   /**
      assignPanel method
      @param panel which players panel is being passed in
   */
	public void assignPanel(PlayerStatsPanel panel){
		this.panel = panel;
	}

	/**
      disableNames method
      sets the panel passed in's JTextField to ineditable
   */
	public void disableNames(){
		panel.player1Name.setEditable(false);
	}

	/**
      setName method
      @param newName the new name chosen by the player
   */
	public void setName(String newName) {
		name = newName;
		panel.refresh();
	}

	/**
      getName method
      @return the name for the JTextField of a player's panel
   */
	public String getName() {
		return name;
	}

	/**
      incrementWins method
   */
	public void incrementWins() {
		wins++;
		panel.refresh();
	}

	/**
      getWins method
      @return the wins for the JTextField of a player's panel
   */
	public int getWins() {
		return wins;
	}

	/**
      incrementLosses method
   */
	public void incrementLosses() {
		losses++;
		panel.refresh();
	}

	/**
      getLosses method
      @return the losses for the JTextField of a player's panel
   */
	public int getLosses() {
		return losses;
	}

	/**
      getSymbolIcon method
      @return the symbol to know which icon won
   */
	public ImageIcon getSymbolIcon() {
		return symbol;
	}

	/**
      reset method
      resets the player's panel back to the initial state
   */
	public void reset(){
		wins = 0;
		losses = 0;
		panel.refresh();
		panel.player1Name.setText(initialName);
		panel.player1Name.setEditable(true);

	}

}