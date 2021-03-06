
/**
 * Assignment 3
 * Due Date: 2/22/19
 * Authors: Ayla McKorkle and Kasey Davis
 * Github: amckorkle
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {
    Player player1 = new Player("icons/X.png", "Player 1");
    Player player2 = new Player("icons/O.png", "Player 2");
    GameBoard board = new GameBoard(new Player[] { player1, player2 });
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private GridPanel gameBoardPanel;
    private GameInfoPanel gameLabel;
    private BuildButtonPanel exitButton;
    private JPanel centerPanel;
    private PlayerStatsPanel player1Panel;
    private PlayerStatsPanel player2Panel;
    private JPanel upperPanel;

    /*
     * consturctor
     */
    public TicTacToe() {
        setTitle("Tic Tac Toe");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        centerPanel = new JPanel(new BorderLayout());
        upperPanel = new JPanel(new BorderLayout());

        gameLabel = new GameInfoPanel();
        gameBoardPanel = new GridPanel(board);
        board.assignGridPanel(gameBoardPanel);
        board.assignGameInfoPanel(gameLabel);
        exitButton = new BuildButtonPanel(board, player1, player2, gameLabel);
        player1Panel = new PlayerStatsPanel(player1, "Player 1 (X)");
        player2Panel = new PlayerStatsPanel(player2, "Player 2 (O)");
        player1.assignPanel(player1Panel);
        player2.assignPanel(player2Panel);

        centerPanel.add(gameBoardPanel, BorderLayout.CENTER);
        centerPanel.add(exitButton, BorderLayout.SOUTH);

        upperPanel.add(player1Panel, BorderLayout.WEST);
        upperPanel.add(player2Panel, BorderLayout.EAST);

        add(centerPanel, BorderLayout.CENTER);
        add(gameLabel, BorderLayout.SOUTH);
        add(upperPanel, BorderLayout.NORTH);

        setVisible(true);
        player1Panel.refresh();
        player2Panel.refresh();

    }

    /**
     * main method
     */
    public static void main(String[] args) {
        new TicTacToe();
    }
}
