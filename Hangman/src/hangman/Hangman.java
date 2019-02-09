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
        /*
        String display;
        String output;
        boolean correctGuess = true;
        int numberOfGuesses = 0;
        String userGuess = " "; 
        String dashes;
        */
        if(isOne(userChoice)){
            String randomWord = chooseWordRandomly();
            mainGameplayLoop(randomWord);    
        }
        else if(isTwo(userChoice)){
            String userWord = inputUserWord();
            mainGameplayLoop(userWord);
        }
        else{
            exitMessage();
        }
        
        System.exit(0);
    }
    
    public static void mainGameplayLoop(String secretWord){
        boolean[] guessedLetters = new boolean[secretWord.length()];
        int strikes = 0;
        String displayString, userGuess = " ";
        boolean isCorrectGuess;

        while(strikes < 6 && !isSolved(guessedLetters)){
            displayString = makeDisplayString(strikes, secretWord, guessedLetters); 

            userGuess = getInputLetter(displayString);

            isCorrectGuess = checkGuess(secretWord, userGuess);
            if(!isCorrectGuess){
                strikes++;
            } else {
                updateGuessedLetters(secretWord, userGuess, guessedLetters);                 
            }
        }

        if(isSolved(guessedLetters)){
            JOptionPane.showMessageDialog(null, "The word was: " + secretWord + "\n You won!");        }
        else{
            JOptionPane.showMessageDialog(null, "The word was: " + secretWord + "\n" + makePerson(strikes) + "Sorry you lost");
        }
    }
    
    public static int menu(){
        String userOption = JOptionPane.showInputDialog("1. Play game from a randomly chosen word in a list \n 2. Play game from a word entered by another user \n 3. Exit Game");
        int userChoice = Integer.parseInt(userOption);
        return userChoice;
    }
    
    public static String getInputLetter(String displayString){
        String guess = JOptionPane.showInputDialog(displayString);
        
        while(guess.length() != 1 || !Character.isLetter(guess.charAt(0))){
            guess = JOptionPane.showInputDialog(displayString + "\nInput must be a single letter.");
        }
        return guess;
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
    
    public static String makeDisplayString(int strikes, String secretWord, boolean[] guessedLetters){
        String displayString = "--- HANGMAN ---\n";
        displayString += "\n";
        displayString += makePerson(strikes);
        displayString += "\n";		
        displayString += getGuessedString(secretWord, guessedLetters);
        displayString += "\n";		
        displayString += "\nGuess another letter.";
        return displayString;
    }
        
    public static boolean checkGuess(String secretWord, String userGuess){
        return secretWord.toLowerCase().contains(userGuess.toLowerCase());
    }

    public static String makePerson(int strikes){
        String person = "     \n     \n     \n";
        switch(strikes){
            case 6:
                person = replaceChar(person, 15, '\\');
                person = replaceChar(person, 16, '_');
            case 5:
                person = replaceChar(person, 12, '_');
                person = replaceChar(person, 13, '/');
            case 4:
                person = replaceChar(person, 9, '-');
                person = replaceChar(person, 10, '-');
            case 3:
                person = replaceChar(person, 6, '-');
                person = replaceChar(person, 7, '-');
            case 2:
                person = replaceChar(person, 8, '|');
            case 1:
                person = replaceChar(person, 1, 'O');
                break;
        }
        return person;
    }

    public static String replaceChar(String str, int index, char newChar){
        String newStr = str.substring(0, index) + newChar + str.substring(index + 1);
        return newStr;
    }
        

    public static String getGuessedString(String secretWord, boolean[] guessedLetters){
        String displayString = "";
                
        for(int i = 0; i < secretWord.length(); i++){
            if(guessedLetters[i]){
                displayString += secretWord.charAt(i);
            } else {
                displayString += "-";
            }
        }

        return displayString;
    }
        
    public static void updateGuessedLetters(String secretWord, String userGuess, boolean[] guessedLetters){
        for(int i = 0; i < secretWord.length(); i++){
            if(secretWord.toLowerCase().charAt(i) == userGuess.toLowerCase().charAt(0)){
                guessedLetters[i] = true;
            }
        }
    }
    
    public static String inputUserWord(){
        String userWord = JOptionPane.showInputDialog("Please enter a word.");
        while(!isOnlyLetters(userWord)){
            userWord = JOptionPane.showInputDialog("Please enter a new word. It must only be one word.");
        }
        return userWord;
    }

    public static boolean isOnlyLetters(String str){
        for(int i = 0; i < str.length(); i++){
            if(!Character.isLetter(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isSolved(boolean[] guessedLetters){
        for(int i = 0; i < guessedLetters.length; i++){
            if(!guessedLetters[i]){
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
