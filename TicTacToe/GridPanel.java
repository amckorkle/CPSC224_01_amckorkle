
/**
 * Assignment 3
 * Due Date: 2/22/19
 * Authors: Ayla McKorkle and Kasey Davis
 * Github: amckorkle
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridPanel extends JPanel{
	private GameBoard board;
	JButton[][] buttonGrid;
        
		/*
    * consturctor
    */
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
	
	/**
      refresh method
      adds the icon to the button pressed on the board
   */
	public void refresh(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				buttonGrid[i][j].setIcon(board.getIconAt(i, j));
				
			}
		}
	}

	/**
      clear method
      removes the icons on the board
   */
	public void clear(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				buttonGrid[i][j].setIcon(null);
			}
		}
	}

	/**
      Private inner class that handles the event when
      the user clicks on the the ButtonGrid button.
   */
	private class ButtonClickListener implements ActionListener {
		JButton[][] buttonGrid;
		GameBoard board;

		/*
    * consturctor
    */
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
