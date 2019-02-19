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


public class TicTacToe extends JFrame{
	String p1Name, p2Name;
	int p1Wins = 0;
	int p1Losses = 0;
	int p2Wins = 0;
	int p2Losses = 0;
	char[][] board = new char[3][3];
	static char X = 'X';
	static char O = 'O';

	static char N = '\0';

	public static void main(String[] args){
		TicTacToe ttt = new TicTacToe();
	}

	public TicTacToe(){
		System.out.println(isWinnerTest());
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

	private boolean isWinnerTest(){
		setBoard(N, N, N, N, N, N, N, N, N);
		if(isWinner() != -1){
			return false;
		}

		setBoard(O, X, N, O, O, O, N, N, N);
		if(isWinner() != 2){
			return false;
		}

		setBoard(X, N, N, N, X, N, N, N, X);
		if(isWinner() != 1){
			return false;
		}

		setBoard(X, N, O, X, N, O, X, O, N);
		if(isWinner() != 1){
			return false;
		}

		setBoard(X, N, N, N, X, N, O, O, O);
		if(isWinner() != 2){
			return false;
		}

		setBoard(X, X, O, N, O, N, O, X, N);
		if(isWinner() != -1){
			return false;
		}




		return true;
	}
}
