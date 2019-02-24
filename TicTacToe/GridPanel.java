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

public class GridPanel extends JPanel{
	private GameBoard board;
	JButton[][] buttonGrid;
        
    public GridPanel(GameBoard board){
		this.board = board;

		setLayout(new GridLayout(3,3));
		
		
		buttonGrid = new JButton[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				buttonGrid[i][j] = new JButton();
				buttonGrid[i][j].addActionListener(new ButtonClickListener(buttonGrid, board));
				add(buttonGrid[i][j]);
				buttonGrid[i][j].setEnabled(false);
			}
		}
	}
	
	public void refresh(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				buttonGrid[i][j].setIcon(board.getIconAt(i, j));
			}
		}
	}

	private class ButtonClickListener implements ActionListener {
		JButton[][] buttonGrid;
		GameBoard board;
		public ButtonClickListener(JButton[][] buttonGrid, GameBoard board){
			this.buttonGrid = buttonGrid;
			this.board = board;
		}
		public void actionPerformed(ActionEvent e){
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(e.getSource() == buttonGrid[i][j]){
						if(!board.isPlayerAt(i, j)){
							board.handleGameplayEvent(i, j);
							buttonGrid[i][j].setIcon(board.getIconAt(i, j));
						}
					}
				}
			}
		}
	}
}
