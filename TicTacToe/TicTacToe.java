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
	String p1Name, p2Name;
	int p1Wins = 0;
	int p1Losses = 0;
	int p2Wins = 0;
	int p2Losses = 0;
	char[][] board = new char[3][3];
        private final int WINDOW_WIDTH = 500;
        private final int WINDOW_HEIGHT = 500;
        private JButton newGame;
        private JButton reset;
        private JButton exit;
        private JButton upperLeft;
        private JButton upperCenter;
        private JButton upperRight;
        private JButton middleLeft;
        private JButton middleCenter;
        private JButton middleRight;
        private JButton lowerLeft;
        private JButton lowerCenter;
        private JButton lowerRight;
        private JLabel messageLabel;
        private JTextField player1;
        private JTextField player2;
        
        public TicTacToe(){
            setTitle("Tic Tac Toe");
            
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setLayout(new BorderLayout());
            
            messageLabel = new JLabel("Welcome to Tic-Tac-Toe!");
            add(messageLabel, BorderLayout.SOUTH);
            
            setVisible(true);
              
        }
        

        
	public static void main(String[] args){
            new TicTacToe();
	}

}
