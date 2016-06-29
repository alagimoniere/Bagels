/* Player.java

 * Author: Alyssa Lagimoniere
 * Submission Date: 4/3/15
 * 
 * Purpose: A class to define the methods used for the Bagels driver
 * that will store the player's name and their stats (games played, number of moves, and fastest win).
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

public class Player {
	
	//Define variables
	private String name;
	private int fastestWin;
	private int gamesCompleted;

	//Define scanner
	private Scanner keyboard = new Scanner(System.in);
	
	//Using the keyboard field, the guess is read in from the keyboard as a string
	public String askForGuess() {
		String guess = keyboard.nextLine();
		return guess;
	}
	
	//Returns the player's name
	public String getName() {
		return name;
	}
	
	//Returns the fastest win
	public int getFastestWin() {
		return fastestWin;
	}
	
	//Returns the number of games completed
	public int getGamesCompleted() {
		return gamesCompleted;
	}
	
	//Sets the player's name
	public void setName(String name) {
		this.name = name;
	}
	
	//Should be called once after finishing each game. It updates the gamesCompleted
	//field and possibly the fastestWin field
	public void updateStats(int numberOfMovesTakenToWin) {
		if (numberOfMovesTakenToWin < fastestWin || fastestWin == 0) 
			fastestWin = numberOfMovesTakenToWin;
		gamesCompleted++;
	}
}
