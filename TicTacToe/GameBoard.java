import javax.swing.*;

public class GameBoard {
	private Player[][] board;
	private Player[] playerList;
	private int nextPlayerTurn = 0;
	private int turnCount = 0;

	public GameBoard(Player[] players){
		board = new Player[3][3];
		playerList = players;
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
			winner.incrementWins();
			for(Player player : playerList){
				if(player != winner){
					player.incrementLosses();
				}
			}
		}

		if(turnCount >= 9){
			for(Player player : playerList){
				player.incrementLosses();
			}
		}
	}

	public Player playerAt(int row, int col){
		return board[row][col];
	}	

	public void place(int row, int col, Player player){
		board[row][col] = player;
	}

	public void reset(){
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;
            }
		}

		nextPlayerTurn = 0;
		turnCount = 0;
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

        while (board[2][2] != null && board[2][2] == board[2 - idx][2 - idx] && idx < 3) {
            if (idx == 2) {
                return board[2][2];
            }
            idx++;
        }

        return null;
    }

}