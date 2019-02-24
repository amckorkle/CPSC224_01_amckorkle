import javax.swing.*;

public class GameBoard {
	private Player[][] board;
	private Player[] playerList;
	private GridPanel gridPanel;
	private GameInfoPanel gameInfoPanel;	
	private int nextPlayerTurn = 0;
	private int turnCount = 0;

	public GameBoard(Player[] players){
		board = new Player[3][3];
		playerList = players;
		
	}

	public void assignGridPanel(GridPanel gridPanel){
		this.gridPanel = gridPanel;
	}

	public void assignGameInfoPanel(GameInfoPanel panel){
		gameInfoPanel = panel;
	}

	public void enableGrid(){
		gameInfoPanel.setInfoPanelText(playerList[nextPlayerTurn].getName() + "'s turn.");
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
          		gridPanel.buttonGrid[i][j].setEnabled(true);
        	}
    	}
	}

	public void disableGrid(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				gridPanel.buttonGrid[i][j].setEnabled(false);
			}
		}
	}

	public ImageIcon getIconAt(int row, int col){
		if(playerAt(row, col) != null){
			return playerAt(row, col).getSymbolIcon();
		}

		return null;
	}

	public void handleGameplayEvent(int row, int col){
		place(row, col, playerList[nextPlayerTurn]);
		incrementNextPlayerTurn();
		turnCount++;

		Player winner = winnerExists();
		if(winner != null){
			gameInfoPanel.setInfoPanelText(winner.getName() + " won!");
			disableGrid();
			winner.incrementWins();
			for(Player player : playerList){
				if(player != winner){
					player.incrementLosses();
				}
			}

		} else if(turnCount >= 9){
			gameInfoPanel.setInfoPanelText("Cat's game--no one wins.");
			disableGrid();
			for(Player player : playerList){
				player.incrementLosses();
			}

		} else {
			gameInfoPanel.setInfoPanelText(playerList[nextPlayerTurn].getName() + "'s turn.");
		}

	}

	public Player playerAt(int row, int col){
		return board[row][col];
	}	

	public void place(int row, int col, Player player){
		board[row][col] = player;
	}

	public void reset(boolean isReset){
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;
				if(isReset)
					gridPanel.buttonGrid[i][j].setEnabled(false);
            }
		}

		nextPlayerTurn = 0;
		turnCount = 0;
		gridPanel.clear();
		gameInfoPanel.setInfoPanelText(playerList[nextPlayerTurn].getName() + "'s turn.");
	}

	private void incrementNextPlayerTurn(){
		nextPlayerTurn++;
		nextPlayerTurn %= playerList.length;
	}

	public boolean isPlayerAt(int row, int col){
		return board[row][col] != null;
	}

	public Player winnerExists() {
        // Check horizontals
        for (int row = 0; row < 3; row++) {
            int idx = 1;
            while (board[row][0] != null && board[row][0] == board[row][idx] && idx < 3) {
                if (idx == 2) {
                    return board[row][0];
                }
                idx++;
            }
        }

        // Check verticals
        for (int col = 0; col < board.length; col++) {
            int idx = 1;
            while (board[0][col] != null && board[0][col] == board[idx][col] && idx < 3) {
                if (idx == 2) {
                    return board[0][col];
                }
                idx++;
            }
        }

        // Check diagonals
        int idx = 1;
        while (board[0][0] != null && board[0][0] == board[idx][idx] && idx < 3) {
            if (idx == 2) {
                return board[0][0];
            }
            idx++;
        }

        while (board[0][2] != null && board[0][2] == board[idx][2 - idx] && idx < 3) {
            if (idx == 2) {
                return board[0][2];
            }
            idx++;
        }

        return null;
    }

}