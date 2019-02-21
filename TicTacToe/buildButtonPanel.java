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

public class buildButtonPanel extends JPanel {
    private JButton newGame;
    private JButton reset;
    private JButton exit;
    
    public buildButtonPanel(){
        
        
        exit = new JButton("Exit");
        exit.addActionListener(new ExitButtonListener());
        
        add(exit);
    }
    
    private class ExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
}
}
