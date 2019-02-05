/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import javax.swing.JOptionPane;
/**
 *
 * @author aylam
 */
public class Hangman {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int userChoice = menu();
        if(userChoice == 1){}
        else if(userChoice == 2){}
        else{
            exitMessage();
        }
    }
    
    public static int menu(){
        String userOption = JOptionPane.showInputDialog("1. Play game from a randomly chosen word in a list \n 2. Play game from a word entered by another user \n 3. Exit Game");
        int userChoice = Integer.parseInt(userOption);
        return userChoice;
    }
    
    public static void exitMessage(){
        System.out.println("Thanks for playing hangman");
    }
    
}
