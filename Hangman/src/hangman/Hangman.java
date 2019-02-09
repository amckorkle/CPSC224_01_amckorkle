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
        String secretWord = "";
        String display;
        String output;
        int numberOfGuesses = 0;
        String userGuess = " ";
        String dashes;
        int strikes = 0;
        int round = 1;
        
        if(isOne(userChoice)){
                String randomWord = chooseWordRandomly();
                boolean[] guessedLetters = new boolean[randomWord.length()];
                System.out.println(randomWord);
                while(!isSolved(guessedLetters, randomWord)){
                    display = makeDisplayString(numberOfGuesses, randomWord, guessedLetters); 
                    output = JOptionPane.showInputDialog(display);
                }
        }
        else if(isTwo(userChoice)){
            String userWord = inputUserWord();
            System.out.println(userWord);
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
    
    public static String getUserGuess(String dashes){
        String userGuess = JOptionPane.showInputDialog(dashes);
        return userGuess; 
	}
	
	public static String makeDisplayString(int numberOfGuesses, String secretWord, boolean[] guessedLetters){
		String displayString = "--- HANGMAN ---\n";
		displayString += "\n";
		displayString += makePerson(numberOfGuesses);
		displayString += "\n";		
		displayString += getGuessedString(secretWord, guessedLetters);
		displayString += "\n";		
		displayString += "\nGuess another letter.";
		return displayString;
	}

	public static String makePerson(int numberOfGuesses){
		String person = "     \n     \n     \n";
		switch(numberOfGuesses){
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
		/*
			  O
			--|--
			_/ \_
		*/
		return person;
	}

	public static String replaceChar(String str, int index, char newChar){
		String newStr = str.substring(0, index) + newChar + str.substring(index + 1);
		return newStr;
	}
        
        public static 

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
