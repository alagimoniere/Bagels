/* Bagels.java

 * Author: Alyssa Lagimoniere
 * Submission Date: 4/3/15
 * 
 * Purpose: To execute a game of "Pico, Fermi, Bagel" by creating our 
 * own classes and methods.
 * 
 * Statement of Academic Honesty: 
 * 
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. 
 */

import java.util.Scanner;

public class Bagels {

	public static void main(String[] args) {
		
		//Define variables
		boolean isCorrect = false;
		Scanner keyboard = new Scanner(System.in);
		String answer;
		
		//Welcome
		System.out.println("Welcome!");
		
		do { 
			//Make objects
			Player player = new Player();
			Engine engine = new Engine();
			
			//Enter digits and name
			System.out.println("");
			System.out.print("Enter number of digits to use: ");
			int numDigits = keyboard.nextInt();
			engine.setNumDigits(numDigits);
			System.out.print("Enter player name: ");
			String name = keyboard.next();
			player.setName(name);
				
			do {
				int guessCount = 0;
	
				//Start game
				System.out.println("\nStarting game #" + (player.getGamesCompleted() + 1) + ".");
				
				//Get random number
				engine.generateNewSecret();
				//for (int i = 0; i < engine.getSecretNumber().length; i++) {
				//	System.out.print(engine.getSecretNumber()[i]);
				//}
				
				do {
					//Ask for guess
					System.out.println("");
					System.out.print("Enter your guess: ");
					String guessString = player.askForGuess();
					int[] guess = engine.convertNumToDigitArray(guessString);
					guessCount++;
					
					//Validate
					isCorrect = Validator.validateGuess(engine.getSecretNumber(), guess, numDigits);
					
				} while (!isCorrect);
					
				//Print stats
				player.updateStats(guessCount);
				System.out.println("Congratulations! You won in " + guessCount + " moves.");
				System.out.println("");
				System.out.println("Statistics for " + player.getName() + ":");
				System.out.println("Games completed: " + player.getGamesCompleted());
				System.out.println("Number of digits: " + engine.getNumDigits());
				System.out.println("Fastest win: " + player.getFastestWin() + " guesses");
				
				//Ask player what they want to do next
				System.out.println("p - Play again");
				System.out.println("r - Reset game");
				System.out.println("q - Quit");
				System.out.println("");
				System.out.print("What would you like to do? ");
				answer = keyboard.next();
				if (answer.equals("q")) {
					System.out.println("");
					System.out.println("Goodbye!");
					System.exit(0);
				} else {
					continue;
				}
					
			} while (answer.equals("p"));
			
		} while (answer.equals("r"));
		
	}
	
}