package hangman;
import javax.swing.JOptionPane;
import java.util.*;

/**
 * Homework #2
 * due date: 2/11/19
 * names: Ayla McKorkle and Kasey Davis
 * github: amckorkle
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
    
    /**
      The mainGameplayLoop method allows the game to be played
      @param secretWord is the word the user is to guess used in other functions
   */
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
    
    /**
      The menu method returns the user's choice from a menu
      @return the value in the userChoice field
   */
    public static int menu(){
        String userOption = JOptionPane.showInputDialog("1. Play game from a randomly chosen word in a list \n 2. Play game from a word entered by another user \n 3. Exit Game");
        int userChoice = Integer.parseInt(userOption);
        return userChoice;
    }
    
    /**
      The getInputLetter method returns the user's guess
      @return the value in the guess field
      @param displayString the value displayed in the dialog box
   */
    public static String getInputLetter(String displayString){
        String guess = JOptionPane.showInputDialog(displayString);
        
        while(guess.length() != 1 || !Character.isLetter(guess.charAt(0))){
            guess = JOptionPane.showInputDialog(displayString + "\nInput must be a single letter.");
        }
        return guess;
    }

    /**
      The isOne method returns if the user has entered 1 or not
      @return the value of userChoice == 1
      @param userChoice the value being evaluated for it's contents
   */
    public static boolean isOne(int userChoice){
        return (userChoice == 1);
    }
    
    /**
      The isTwo method returns if the user has entered 2 or not
      @return the value of userChoice == 2
      @param userChoice the value being evaluated for it's contents
   */
    public static boolean isTwo(int userChoice){
        return (userChoice == 2);
    }
    
    /**
      The exitMessage method displays a message to the user
   */
    public static void exitMessage(){
        System.out.println("Thanks for playing hangman");
    }
    
    /**
      The chooseWordRandomly method returns a random word chosen from an array
      @return the value of randomWord
   */
    public static String chooseWordRandomly(){
        String[] words = {"smoothie", "teeth", "dog", "food", "homework", "math", "zebra", "penguin"};
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        String randomWord = words[index];
        return randomWord;
    }
    
    /**
      The makeDisplayString method returns the message to be displayed to the user
      @return the value in displayString
      @param strikes the value of incorrect guesses
      @param secretWord the value of the word to be guessed
      @param guessedLetters the true/false value of whether each character in secretWord had been guessed 
   */
    public static String makeDisplayString(int strikes, String secretWord, boolean[] guessedLetters){
        String displayString = "--- HANGMAN ---\n";
        displayString += "\n";
        displayString += makePerson(strikes);
        displayString += "Strikes: " + strikes + ".\n";
        displayString += "\n";		
        displayString += getGuessedString(secretWord, guessedLetters);
        displayString += "\n";		
        displayString += "\nGuess another letter.";
        return displayString;
    }
        
    /**
      The checkGuess method returns the lowercase letter of the user's guess
      @return the value in secretWord.toLowerCase().contains(userGuess.toLowerCase())
      @param secretWord the value of the word to be guessed
      @param userGuess the character the user guessed 
   */
    public static boolean checkGuess(String secretWord, String userGuess){
        return secretWord.toLowerCase().contains(userGuess.toLowerCase());
    }

    /**
      The makePerson method returns the person to be displayed
      @return the value in person
      @param strikes the value of incorrect guesses
   */
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

    /**
      The replaceChar method returns the body part of the string of the person
      @return the value in newStr
      @param str the value of the display for the user
      @param index the value of the location in the string
      @param newChar the value of the new character to be added to the string 
   */
    public static String replaceChar(String str, int index, char newChar){
        String newStr = str.substring(0, index) + newChar + str.substring(index + 1);
        return newStr;
    }
        
    /**
      The getGuessedString method returns the display of the word the user is guessing
      @return the value in displayString
      @param secretWord the value of the word to be guessed
      @param guessedLetters the true/false value of whether each character in secretWord had been guessed 
   */
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
        
    /**
      The updateGuessedLetters method updates whether characters in the word have been guessed
      @param secretWord the value of the word to be guessed
      @param userGuess the value the user has guessed
      @param guessedLetters the true/false value of whether each character in secretWord had been guessed 
   */
    public static void updateGuessedLetters(String secretWord, String userGuess, boolean[] guessedLetters){
        for(int i = 0; i < secretWord.length(); i++){
            if(secretWord.toLowerCase().charAt(i) == userGuess.toLowerCase().charAt(0)){
                guessedLetters[i] = true;
            }
        }
    }
    
    /**
      The inputUserWord method returns the word the user has entered
      @return the value in userWord 
   */
    public static String inputUserWord(){
        String userWord = JOptionPane.showInputDialog("Please enter a word.");
        while(!isOnlyLetters(userWord)){
            userWord = JOptionPane.showInputDialog("Please enter a new word. It must only be one word.");
        }
        return userWord;
    }

    /**
      The isOnlyLetters method returns whether the user entered word contains only letters
      @return true if the word contains only letters, false otherwise
      @param str the value entered by the user
   */
    public static boolean isOnlyLetters(String str){
        for(int i = 0; i < str.length(); i++){
            if(!Character.isLetter(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    /**
      The isSolved method returns whether the word has been solved
      @return true if the word is solved, false otherwise
      @param guessedLetters the true/false value of whether each character in secretWord had been guessed 
   */
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
