/*
	ICA1
	due date: 1/25/19
	name: Ayla McKorkle
*/

import java.util.*;

public class ICA1{
	public static void main(String[] args){
		double distance = -1;
		int userNum = 0;
		while(userNum != 4){
			Scanner keyboard = new Scanner(System.in);
			while(distance < 0){
				System.out.print("Enter a distance in meters: ");
				distance = keyboard.nextDouble();
			}
			menu();
			System.out.print("Enter your choice: ");
			userNum = keyboard.nextInt();
			if(userNum == 1){
				showKilometers(distance);
			}
			else if (userNum == 2){
				showInches(distance);
			}
			else if(userNum == 3){
				showFeet(distance);
			}
			else if(userNum == 4){
				System.out.println("Bye!");
			}
			else{
				System.out.println("Not a valid input");
			}
		}
	}

	public static void showKilometers(double meters){
		double kilometers;
	
		kilometers = meters * 0.001;
		System.out.println(meters + " meters is " + kilometers + " kilometers.");
	}

	public static void showInches(double meters){
		double inches;
	
		inches = meters * 39.37;
		System.out.println(meters + " meters is " + inches + " inches.");
	}	

	public static void showFeet(double meters){
		double feet;
	
		feet = meters * 3.281;
		System.out.println(meters + " meters is " + feet + " feet.");
	}

	public static void menu(){
		System.out.println("1. Convert to Kilometers");
		System.out.println("2. Convert to Inches");
		System.out.println("3. Convert to Feet");
		System.out.println("4. Quit the Program");
		System.out.println();
	}
}

