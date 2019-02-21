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

public class GridPanel extends JPanel{
    private JButton upperLeft;
    private JButton upperCenter;
    private JButton upperRight;
    private JButton middleLeft;
    private JButton middleCenter;
    private JButton middleRight;
    private JButton lowerLeft;
    private JButton lowerCenter;
    private JButton lowerRight;
        
    public GridPanel(){
  
        setLayout(new GridLayout(3,3));
        
        upperLeft = new JButton();
        upperCenter = new JButton();
        upperRight = new JButton();
        middleLeft = new JButton();
        middleCenter = new JButton();
        middleRight = new JButton();
        lowerLeft = new JButton();
        lowerCenter = new JButton();
        lowerRight = new JButton();
        
        add(upperLeft);
        add(upperCenter);
        add(upperRight);
        add(middleLeft);
        add(middleCenter);
        add(middleRight);
        add(lowerLeft);
        add(lowerCenter);
        add(lowerRight);
        
    }
}
