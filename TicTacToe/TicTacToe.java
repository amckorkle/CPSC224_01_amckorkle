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
}
