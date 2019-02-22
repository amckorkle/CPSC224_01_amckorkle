import javax.swing.*;

public class Player {
	private ImageIcon symbol;
	private int wins = 0;
	private int losses = 0;
	private String name;

	public Player(String path) {
		symbol = new ImageIcon(path);
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void incrementWins() {
		wins++;
	}

	public int getWins() {
		return wins;
	}

	public void incrementLosses() {
		losses++;
	}

	public int getLosses() {
		return losses;
	}

	public ImageIcon getSymbolIcon() {
		return symbol;
	}

}