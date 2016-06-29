/* Engine.java

 * Author: Alyssa Lagimoniere
 * Submission Date: 4/3/15
 * 
 * Purpose: A class to define the methods that will store the number
 * of digits the player wants to use as well as generate a secret
 * number for the game.
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

import java.util.Random;

public class Engine {

	//Define variables
	private int numDigits;
	private int[] secretNumber = new int[numDigits];
	private Random randomNumberGenerator = new Random();
	
	//Converts a number as a String to array of ints. The ordering must go from
	//most to least significant digits. For example, if the number String is
	//"732" then index 0 of the array should contain 7.
	public int[] convertNumToDigitArray(String number) {
		int i = 0;
		int[] intArray = new int[number.length()];
		for (i = 0; i < number.length(); i++) {
			intArray[i] = Integer.valueOf(number.substring(i,  i + 1));
		}
		return intArray;
	}
		
	//Returns the number of digits.
	public int getNumDigits() {
		return numDigits;
	}
	
	//Returns the secret number.
	public int[] getSecretNumber() {
		return secretNumber;
	}
	
	//Changes the secretNumber field to a random number in the range 10^(n-1)
	//and (10^n)-1; must be invoked each time a game is started.
	public void generateNewSecret() {
		int secret = randomNumberGenerator.nextInt((int)(Math.pow(10, numDigits) - 1) - (int)(Math.pow(10, numDigits - 1)));
		secret += (int)(Math.pow(10, numDigits - 1));
		secretNumber = new int[numDigits];
		for (int i = 0; i < numDigits; i++) {
			this.secretNumber[numDigits - 1 - i] = secret % 10;
			secret /= 10;
		}
	}
	
	//Sets the number of digits to the input parameter.
	public void setNumDigits(int numDigits) {
		this.numDigits = numDigits;
	}
	
	//Sets the values in this object's secretNumber to a copy of the values
	//in the secretNumber input parameter and the order of values must be
	//the same in this object's secretNumber and the secretNumber input parameter.
	//This method should call the setNumDigits method to update the number of digits
	//based on the input parameter.
	public void setSecretNumber(int[] secretNumber) {
		for (int i = 0; i < secretNumber.length; i++) {
			this.secretNumber[i] = secretNumber[i];
		}
		setNumDigits(secretNumber.length);
	}
}
