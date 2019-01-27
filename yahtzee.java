import java.util.*;



public class Yahtzee1{

	public static void main(String[] args){

		final int DICE_IN_PLAY = 5;

		int[] hand = new int[DICE_IN_PLAY];

		Scanner scnr = new Scanner(System.in);



		char playAgain = 'y';



		while(playAgain == 'y'){

			String keep = "nnnnn";

			int turn = 1;

			while( turn < 4 && keep != "yyyyy" ){

				for(int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++){

					if(keep.charAt(dieNumber) != 'y'){

						hand[dieNumber] = rollDie();

					}

				}



				System.out.print("Your roll was: ");

				for(int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++){

					System.out.print(hand[dieNumber] + " ");

				}

				System.out.println();



				if(turn < 3){

					System.out.print("enter dice to keep (y or n) ");

					keep = scnr.nextLine();

				}

				turn++;

			}



			sortArray(hand, DICE_IN_PLAY);

			System.out.print("Here is your sorted : ");

			for(int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++){

				System.out.print(hand[dieNumber] + " ");

			}

			System.out.println();



			for(int dieValue = 1; dieValue <= 6; dieValue++){

				int currentCount = 0;

				for(int diePosition = 0; diePosition < 5; diePosition++){

					if(hand[diePosition] == dieValue){

						currentCount++;

					}

				}

				System.out.print("Score " + (dieValue * currentCount) + " on the ");

				System.out.print(dieValue + " line\n");

			}



			// The cpp file up to line 71 is present

		}





	}



	static int rollDie(){

		return 1;

	}



	int maxOfAKindFound(int hand[]){

		return 1;

	}



	int totalAllDice(int hand[]){

		return 1;

	}



	static void sortArray(int array[], int size){



	}



	int maxStraightFound(int hand[]){

		return 1;

	}



	boolean fullHouseFound(int hand[]){

		return true;

	}

}