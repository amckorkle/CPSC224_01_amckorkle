import javax.swing.*;

public class Player {
	private ImageIcon symbol;
	private int wins = 0;
	private int losses = 0;
	private String name;
	private PlayerStatsPanel panel;

	public Player(String path, String defaultName) {
		symbol = new ImageIcon(path);
		name = defaultName;
	}

	public void assignPanel(PlayerStatsPanel panel){
		this.panel = panel;
	}

	public void disableNames(){
		panel.player1Name.setEditable(false);
	}

	public void setName(String newName) {
		name = newName;
		panel.refresh();
	}

	public String getName() {
		return name;
	}

	public void incrementWins() {
		wins++;
		panel.refresh();
	}

	public int getWins() {
		return wins;
	}

	public void incrementLosses() {
		losses++;
		panel.refresh();
	}

	public int getLosses() {
		return losses;
	}

	public ImageIcon getSymbolIcon() {
		return symbol;
	}

	public void reset(){
		wins = 0;
		losses = 0;
		panel.refresh();
		panel.player1Name.setEditable(true);
	}

}