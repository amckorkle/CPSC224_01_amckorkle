
/**
 * Assignment 3
 * Due Date: 2/22/19
 * Authors: Ayla McKorkle and Kasey Davis
 * Github: amckorkle
 */

import javax.swing.*;

public class GameBoard {
	private Player[][] board;
	private Player[] playerList;
	private GridPanel gridPanel;
	private GameInfoPanel gameInfoPanel;
	private int nextPlayerTurn = 0;
	private int turnCount = 0;

	/*
	 * consturctor
	 */
	public GameBoard(Player[] players) {
		board = new Player[3][3];
		playerList = players;

	}

	/**
	 * assignGridPanel method
	 * 
	 * @param gridPanel is the gridPanel used to play
	 */
	public void assignGridPanel(GridPanel gridPanel) {
		this.gridPanel = gridPanel;
	}

	/**
	 * assignGameInfoPanel method
	 * 
	 * @param panel is the panel that holds the game info
	 */
	public void assignGameInfoPanel(GameInfoPanel panel) {
		gameInfoPanel = panel;
	}

	/**
	 * enableGrid method enables all of the buttons in the grid to be pushed
	 */
	public void enableGrid() {
		gameInfoPanel.setInfoPanelText(playerList[nextPlayerTurn].getName() + "'s turn.");

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gridPanel.buttonGrid[i][j].setEnabled(true);
			}
		}
	}

	/**
	 * disableGrid method disables all of the buttons in the grid so they cannot be
	 * pushed
	 */
	public void disableGrid() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gridPanel.buttonGrid[i][j].setEnabled(false);
			}
		}
	}

	/**
	 * getIconAt method
	 * 
	 * @param row the row that button is in
	 * @param col the column the button is in
	 * @return the symbol that is on that button or otherwise null
	 */
	public ImageIcon getIconAt(int row, int col) {
		if (playerAt(row, col) != null) {
			return playerAt(row, col).getSymbolIcon();
		}

		return null;
	}

	/**
	 * handleGameplayEvent method
	 * 
	 * @param row the row that button is in
	 * @param col the column the button is in
	 */
	public void handleGameplayEvent(int row, int col) {
		place(row, col, playerList[nextPlayerTurn]);
		incrementNextPlayerTurn();
		turnCount++;

		Player winner = winnerExists();
		if (winner != null) {
			gameInfoPanel.setInfoPanelText(winner.getName() + " won!");
			disableGrid();
			winner.incrementWins();
			for (Player player : playerList) {
				if (player != winner) {
					player.incrementLosses();
				}
			}

		} else if (turnCount >= 9) {
			gameInfoPanel.setInfoPanelText("Cat's game--no one wins.");
			disableGrid();
			for (Player player : playerList) {
				player.incrementLosses();
			}

		} else {
			gameInfoPanel.setInfoPanelText(playerList[nextPlayerTurn].getName() + "'s turn.");
		}

	}

	/**
	 * playerAt method
	 * 
	 * @param row the row that button is in
	 * @param col the column the button is in
	 * @return the button that is at that row and column
	 */
	public Player playerAt(int row, int col) {
		return board[row][col];
	}

	/**
	 * place method
	 * 
	 * @param row    the row that button is in
	 * @param col    the column the button is in
	 * @param player the player that has the turn
	 */
	public void place(int row, int col, Player player) {
		board[row][col] = player;
	}

	/**
	 * playerAt method
	 * 
	 * @param isReset true if we want the board disabled otherwise false
	 */
	public void reset(boolean isReset) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = null;
				if (isReset)
					gridPanel.buttonGrid[i][j].setEnabled(false);
			}
		}

		nextPlayerTurn = 0;
		turnCount = 0;
		gridPanel.clear();
		gameInfoPanel.setInfoPanelText(playerList[nextPlayerTurn].getName() + "'s turn.");
	}

	/**
	 * incrementNewPlayerTurn method
	 */
	private void incrementNextPlayerTurn() {
		nextPlayerTurn++;
		nextPlayerTurn %= playerList.length;
	}

	/**
	 * isPlayerAt method
	 * 
	 * @param row the row that button is in
	 * @param col the column the button is in
	 * @return the button that is at that row and column is null
	 */
	public boolean isPlayerAt(int row, int col) {
		return board[row][col] != null;
	}

	/**
	 * winnerExists method
	 * 
	 * @return the final location to check if the user has won or not
	 */
	public Player winnerExists() {
		// Check horizontals
		int idx;
		for (int row = 0; row < 3; row++) {
			idx = 1;
			while (board[row][0] != null && board[row][0] == board[row][idx] && idx < 3) {
				if (idx == 2) {
					return board[row][0];
				}
				idx++;
			}
		}

		// Check verticals
		for (int col = 0; col < board.length; col++) {
			idx = 1;
			while (board[0][col] != null && board[0][col] == board[idx][col] && idx < 3) {
				if (idx == 2) {
					return board[0][col];
				}
				idx++;
			}
		}

		// Check diagonals
		idx = 1;
		while (board[0][0] != null && board[0][0] == board[idx][idx] && idx < 3) {

			if (idx == 2) {
				return board[0][0];
			}
			idx++;
		}

		idx = 1;
		while (board[0][2] != null && board[0][2] == board[idx][2 - idx] && idx < 3) {
			if (idx == 2) {
				return board[0][2];
			}
			idx++;
		}

		return null;
	}

}