/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    /*
     * To-do: Do we need a UML diagram?
     */
    Player player1 = new Player("icons/X.png");
    Player player2 = new Player("icons/O.png");
    Player[][] board = new Player[3][3];
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private GridPanel gameBoard;
    private GameInfoPanel gameLabel;
    private buildButtonPanel exitButton;
    // private JTextField player1;
    // private JTextField player2;
    private JPanel centerPanel;
    private BuildPlayerStatsPanel player1Panel;

    public TicTacToe() {
        setTitle("Tic Tac Toe");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        centerPanel = new JPanel(new BorderLayout());

        gameLabel = new GameInfoPanel();
        gameBoard = new GridPanel();
        exitButton = new buildButtonPanel();
        player1Panel = new BuildPlayerStatsPanel();

        centerPanel.add(gameBoard, BorderLayout.CENTER);
        centerPanel.add(exitButton, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);
        add(gameLabel, BorderLayout.SOUTH);
        add(player1Panel, BorderLayout.NORTH);

        // pack();

        setVisible(true);

    }

    private void buildGridPanel() {

    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    private Player winnerExists() {
        // Check horizontals
        for (int row = 0; row < board.length; row++) {
            int idx = 1;
            while (board[row][0] != null && board[row][0] == board[row][idx] && idx < 3) {
                if (idx == 2) {
                    return board[row][0];
                }
                idx++;
            }
        }

public class TicTacToe extends JFrame{
	/*
	To-do:
	Make a Makefile
	Do we need a UML diagram?
	Remove testing functions before uploading
	*/
	String p1Name, p2Name;
	int p1Wins = 0;
	int p1Losses = 0;
	int p2Wins = 0;
	int p2Losses = 0;
	char[][] board = new char[3][3];
	static char X = 'X';
	static char O = 'O';
	static char EMPTY = '\0';
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 500;
	private GridPanel gameBoard;
	private GameInfoPanel gameLabel;
        private buildButtonPanel exitButton;
        private JPanel centerPanel;
        private JPanel upperPanel;
        private BuildPlayerStatsPanel player1Panel;
        private BuildPlayer2StatsPanel player2Panel;
        

        
	public TicTacToe(){
		setTitle("Tic Tac Toe");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                setLayout(new BorderLayout());
                
                centerPanel = new JPanel(new BorderLayout());
                upperPanel = new JPanel(new BorderLayout());
                
                gameLabel = new GameInfoPanel();
                gameBoard = new GridPanel();
                exitButton = new buildButtonPanel();
                player1Panel = new BuildPlayerStatsPanel();
                player2Panel = new BuildPlayer2StatsPanel();
		
                centerPanel.add(gameBoard, BorderLayout.CENTER);
                centerPanel.add(exitButton, BorderLayout.SOUTH);
                
                
                upperPanel.add(player1Panel, BorderLayout.WEST);
                upperPanel.add(player2Panel, BorderLayout.EAST);
                
                add(centerPanel, BorderLayout.CENTER);
                add(gameLabel, BorderLayout.SOUTH);
                add(upperPanel, BorderLayout.NORTH);
                
                
                //pack();
		
		setVisible(true);
			
	}
        
        
        private void buildGridPanel() {
            
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
}
