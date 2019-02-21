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
	//private JTextField player1;
	//private JTextField player2;
        private JPanel centerPanel;
        private BuildPlayerStatsPanel player1;

        
	public TicTacToe(){
		setTitle("Tic Tac Toe");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                setLayout(new BorderLayout());
                
                centerPanel = new JPanel(new BorderLayout());
                
                gameLabel = new GameInfoPanel();
                gameBoard = new GridPanel();
                exitButton = new buildButtonPanel();
                player1 = new BuildPlayerStatsPanel();
		
                centerPanel.add(gameBoard, BorderLayout.CENTER);
                centerPanel.add(exitButton, BorderLayout.SOUTH);
                
                add(centerPanel, BorderLayout.CENTER);
                add(gameLabel, BorderLayout.SOUTH);
                add(player1, BorderLayout.NORTH);
                
                
                //pack();
		
		setVisible(true);
			
	}
        
        
        private void buildGridPanel() {
            
        }
 
	public static void main(String[] args){
		new TicTacToe();
	}


	private int isWinner(){
		// Check horizontals
		for(int row = 0; row < board.length; row++){
			int idx = 1;
			while(board[row][0] != '\0' && board[row][0] == board[row][idx] && idx < 3){
				if(idx == 2){
					return getPlayerFromSymbol(board[row][0]);
				}
				idx++;
			}
		}
		
		// Check verticals
		for(int col = 0; col < board.length; col++){
			int idx = 1;
			while(board[0][col] != '\0' && board[0][col] == board[idx][col] && idx < 3){
				if(idx == 2){
					return getPlayerFromSymbol(board[0][col]);
				}
				idx++;
			}
		}

		// Check diagonals
		int idx = 1;
		while(board[0][0] != '\0' && board[0][0] == board[idx][idx] && idx < 3){
			if(idx == 2){
				return getPlayerFromSymbol(board[0][0]);
			}
			idx++;
		}

		while(board[2][2] != '\0' && board[2][2] == board[2-idx][2-idx] && idx < 3){
			if(idx == 2){
				return getPlayerFromSymbol(board[2][2]);
			}
			idx++;
		}

		return -1;
	}

	private int getPlayerFromSymbol(char symbol){
		if(symbol == X){
			return 1;
		} else {
			return 2;
		}
	}

	private void clearBoard(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; i++){
				board[i][j] = EMPTY;
			}
		}
	}

	private void placeSymbol(int col, int row, char symbol){
		board[row][col] = symbol;
	}

	// Function is for testing purposes only
	private void setBoard(char s1, char s2, char s3, char s4, char s5, char s6, char s7, char s8, char s9){
		board[0][0] = s1;
		board[0][1] = s2;
		board[0][2] = s3;
		board[1][0] = s4;
		board[1][1] = s5;
		board[1][2] = s6;
		board[2][0] = s7;
		board[2][1] = s8;
		board[2][2] = s9;
	}

	// Function is for testing purposes only
	private boolean isWinnerTest(){
		setBoard(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY);
		if(isWinner() != -1){
			return false;
		}

		setBoard(O, X, EMPTY, O, O, O, EMPTY, EMPTY, EMPTY);
		if(isWinner() != 2){
			return false;
		}

		setBoard(X, EMPTY, EMPTY, EMPTY, X, EMPTY, EMPTY, EMPTY, X);
		if(isWinner() != 1){
			return false;
		}

		setBoard(X, EMPTY, O, X, EMPTY, O, X, O, EMPTY);
		if(isWinner() != 1){
			return false;
		}

		setBoard(X, EMPTY, EMPTY, EMPTY, X, EMPTY, O, O, O);
		if(isWinner() != 2){
			return false;
		}

		setBoard(X, X, O, EMPTY, O, EMPTY, O, X, EMPTY);
		if(isWinner() != -1){
			return false;
		}
		return true;
	}
}

