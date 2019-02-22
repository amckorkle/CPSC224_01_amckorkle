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

    private void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; i++) {
                board[i][j] = null;
            }
        }
    }

    private void placeSymbol(int col, int row, Player curPlayer) {
        board[row][col] = curPlayer;
    }

    private class Player {
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
}
