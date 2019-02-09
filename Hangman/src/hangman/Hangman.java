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
        String userGuess = " ";
        String dashes;
        int strikes = 0;
        int round = 1;
        
        if(isOne(userChoice)){
                String randomWord = chooseWordRandomly();
                System.out.println(randomWord);
                boolean[] displayDashes = new boolean[randomWord.length()];
            while (!isSolved(displayDashes, randomWord)) {
                dashes = displayDashes(randomWord, userGuess, round, displayDashes);
                userGuess = getUserGuess(dashes);
                //secretWord = displayDashes(randomWord, userGuess, round, displayDashes);
                round++;
            }  
        }
        else if(isTwo(userChoice)){
            String userWord = inputUserWord();
            System.out.println(userWord);
            //dashes = displayDashes(userWord, userGuess, round, displayDashes);
            //userGuess = getUserGuess(dashes);
            //secretWord = displayDashes(userWord, userGuess, round, displayDashes);
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
        String[] words = {"smoothie", "teeth", "dog", "food", "homework", "math", "zebra", "penguin"};
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        String randomWord = words[index];
        return randomWord;
    }
    
    public static String displayDashes(String randomWord, String userGuess, int round, boolean[] displayDashes){
        char[] mysteryWord = new char[randomWord.length()];
        //boolean[] displayDashes = new boolean[randomWord.length()];
        String dashes = "";
        
        if(round == 1){
            for(int i = 0; i < randomWord.length(); i++){
                displayDashes[i] = false;
            }
        }
        
        for(int j = 0; j < randomWord.length(); j++){
            if(!displayDashes[j]){
                if(userGuess.charAt(0) == randomWord.charAt(j)){
                    mysteryWord[j] = userGuess.charAt(0);
                    displayDashes[j] = true;
                }
                else{
                    displayDashes[j] = false;
                    mysteryWord[j] = '-';
                }
            }
            else{
                //displayDashes[j] = false;
                mysteryWord[j] = '-';
            }
            dashes = String.valueOf(mysteryWord);
        }
        JOptionPane.showMessageDialog(null, dashes);
        return dashes;
    }
    
    public static String getUserGuess(String dashes){
        String userGuess = JOptionPane.showInputDialog(dashes);
        return userGuess;
    }
    
    public static String inputUserWord(){
        String userWord = JOptionPane.showInputDialog("Please enter a word");
        return userWord;
    }
    
    public static boolean isSolved(boolean[] displayDashes, String word){
        for(int i = 0; i < word.length(); i++){
            if(!displayDashes[i]){
                return false;
            }
        }
        return true;
    }
    /**
     * menu
     * choose a word
     * display 
     */
}
