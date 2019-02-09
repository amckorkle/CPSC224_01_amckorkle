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
		int numberOfGuesses = 0;
        String userGuess = " ";
        String dashes;
        
        if(isOne(userChoice)){
            String randomWord = chooseWordRandomly();
            System.out.println(randomWord);
            dashes = displayDashes(randomWord, userGuess);
            userGuess = getUserGuess(dashes);
            secretWord = displayDashes(randomWord, userGuess);
            
        }
        else if(isTwo(userChoice)){
            String userWord = inputUserWord();
            System.out.println(userWord);
            dashes = displayDashes(userWord, userGuess);
            userGuess = getUserGuess(dashes);
            secretWord = displayDashes(userWord, userGuess);
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
    
    public static String displayDashes(String randomWord, String userGuess){
        char[] mysteryWord = new char[randomWord.length()];
        boolean[] displayDashes = new boolean[randomWord.length()];
        int round = 1;
        String dashes = "";
        
        if(round == 1){
            for(int i = 0; i < randomWord.length(); i++){
                displayDashes[i] = false;
            }
        }
        round++;
        
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
            dashes = String.valueOf(mysteryWord);
        }
        JOptionPane.showMessageDialog(null, dashes);
        return dashes;
    }
    
    public static String getUserGuess(String dashes){
        String userGuess = JOptionPane.showInputDialog(dashes);
        return userGuess; //what
	}
	
	public static String makeDisplayString(int numberOfGuesses, String secretWord, boolean[] guessedLetters){
		String displayString = "--- HANGMAN ---\n";
		displayString += makePerson(numberOfGuesses);
		displayString += getGuessedString(secretWord, guessedLetters);
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
				person = replaceChar(person, 2, 'O');
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
    /**
     * menu
     * choose a word
     * display 
     */
}
