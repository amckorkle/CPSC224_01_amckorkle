/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import javax.swing.JOptionPane;
import java.util.*;

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
        String secretWord;
        String userGuess;
        String dashes = "";
        
        if(isOne(userChoice)){
            String randomWord = chooseWordRandomly();
            System.out.println(randomWord);
            dashes = initializeDashes(randomWord);
            userGuess = getUserGuess(dashes);
            secretWord = displayDashes(randomWord, userGuess, dashes);
            
        }
        else if(isTwo(userChoice)){
            
        }
        else{
            exitMessage();
        }
        
        System.exit(0);
    }
    
    public static int menu(){
        String userOption = JOptionPane.showInputDialog("1. Play game from a randomly chosen word in a list \n 2. Play game from a word entered by another user \n 3. Exit Game");
        int userChoice = Integer.parseInt(userOption);
        return userChoice;
    }
    
    public static boolean isOne(int userChoice){
        return (userChoice == 1);
    }
    
    public static boolean isTwo(int userChoice){
        return (userChoice == 2);
    }
    
    public static void exitMessage(){
        System.out.println("Thanks for playing hangman");
    }
    
    public static String chooseWordRandomly(){
        String[] words = {"Smoothie", "Teeth", "Dog", "Food", "Homework", "Math", "Zebra", "Penguin"};
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        String randomWord = words[index];
        return randomWord;
    }
    
    public static String displayDashes(String randomWord, String userGuess, String dashes){
        char[] mysteryWord = new char[randomWord.length()];
        
        for(int j = 0; j < randomWord.length(); j++){
            if(userGuess.charAt(0) == randomWord.charAt(j)){
                mysteryWord[j] = userGuess.charAt(0);
            }
            else{
                mysteryWord[j] = '-';
            }
            dashes = String.valueOf(mysteryWord);
        }
        JOptionPane.showMessageDialog(null, dashes);
        return dashes;
    }
   
    public static String initializeDashes(String randomWord){
        String dashes = "";
        String userGuess;
        char[] mysteryWord = new char[randomWord.length()];
        
        for(int i = 0; i < randomWord.length(); i++){
            mysteryWord[i] = '-';
            dashes = String.valueOf(mysteryWord);
        }
        
        return dashes;
    }
 
    public static String getUserGuess(String dashes){
        String userGuess = JOptionPane.showInputDialog(dashes);
        return userGuess; //what
    }
}
