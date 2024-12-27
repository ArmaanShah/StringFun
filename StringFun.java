/*
 * StringFun.java
 * Author:  Armaan Shah
 * Submission Date: October 16th 2024
 *
 *This program does the following:
 * The following code takes an input of a string and manipulates it according to 
 * what the user wants. It can reverse the string, replace characters, remove characters 
 * or end the program all together. 
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
 * on an assignment created by the School of Computing 
 * at the University of Georgia. Any publishing or
 * posting of source code for this assignment is strictly 
 * prohibited unless you have written consent from the 
 * School of Computing at the University of Georgia.  
 */

import java.util.Scanner;

public class StringFun {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the string to be manipulated:");
		//takes user input 
		String UserSentence = scanner.nextLine();
		String command;

		boolean running = true;
		while (running) {
			// takes the command the user wants to use to manipulate the string
			System.out.println("Enter your command (reverse, replace first, replace last, remove all, remove, quit)");
			command = scanner.nextLine();

			if (command.equalsIgnoreCase("quit")) {
				running = false;
				// reverse code is run if user inputs reverse
			} else if (command.equalsIgnoreCase("reverse")) {
				String reversed = "";
				for (int i = UserSentence.length() - 1; i >= 0; i--) {
					reversed = reversed + UserSentence.charAt(i);
				}
				UserSentence = reversed;
				System.out.println("The new sentence is: " + UserSentence);
			} // replaces the first character in the sentence with the user input
			else if (command.equalsIgnoreCase("replace first")) {
				System.out.println("Enter the character to replace");
				char oldCharacter = scanner.nextLine().charAt(0);
				System.out.println("Enter the new character");
				char newCharacter = scanner.nextLine().charAt(0);

				String result = "";
				boolean replaced = false;

				for (int i = 0; i < UserSentence.length(); i++) {
					if (UserSentence.charAt(i) == oldCharacter && !replaced) {
						result = result + newCharacter;
						replaced = true;
					} else {
						result = result + UserSentence.charAt(i);
					}
				}
				//prints statement with replaced character
				if (replaced) {
					UserSentence = result;
					System.out.println("The new sentence is: " + UserSentence);
				} else {
					System.out.println("The letter was not found in the word");
				}
			} // replaces the last character in the sentence with the user input
			else if (command.equalsIgnoreCase("replace last")) {
				System.out.println("Enter the character to replace");
				char oldCharacter = scanner.nextLine().charAt(0);
				System.out.println("Enter the new character");
				char newCharacter = scanner.nextLine().charAt(0);

				String result = "";
				int lastIndex = -1;

				for (int i = 0; i < UserSentence.length(); i++) {
					if (UserSentence.charAt(i) == oldCharacter) {
						lastIndex = i;
					}
				}

				if (lastIndex != -1) {
					for (int i = 0; i < UserSentence.length(); i++) {
						if (i == lastIndex) {
							result = result + newCharacter;
						} else {
							result = result + UserSentence.charAt(i);
						}
					} // prints the sentence with the last character replaced
					UserSentence = result;
					System.out.println("The new sentence is: " + UserSentence);
				} else {
					System.out.println("The letter was not found in the word");
				} // removes all the characters that the user enters
			} else if (command.equalsIgnoreCase("remove all")) {
				System.out.println("Enter the character to remove");
				char charToRemove = scanner.nextLine().charAt(0);

				String result = "";
				for (int i = 0; i < UserSentence.length(); i++) {
					if (UserSentence.charAt(i) != charToRemove) {
						result = result + UserSentence.charAt(i);
					}
				}
				//prints the sentence with the character removal
				UserSentence = result;
				System.out.println("The new sentence is: " + UserSentence);
				// removes character at specific index
			} else if (command.equalsIgnoreCase("remove")) {
				System.out.println("Enter the character to remove");
				char charToRemove = scanner.nextLine().charAt(0);
				System.out.println("Enter the " + charToRemove
						+ " you would like to remove (Not the index - 1 = 1st, 2 = 2nd, etc.):");
				int occurrence = Integer.parseInt(scanner.nextLine());

				String result = "";
				int count = 0;
				boolean removed = false;

				for (int i = 0; i < UserSentence.length(); i++) {
					if (UserSentence.charAt(i) == charToRemove) {
						count++;
						if (count == occurrence) {
							removed = true;
						} else {
							result = result + UserSentence.charAt(i);
						}
					} else {
						result = result + UserSentence.charAt(i);
					}
				}
				//prints sentence with removal
				if (removed) {
					UserSentence = result;
					System.out.println("The new sentence is: " + UserSentence);
				} else {
					System.out.println("Error: the letter you are trying to remove does not exist");
				}
			} else {
				System.out.println("Command invalid. Try again");
			}
		}

		scanner.close();

	}// main method

}// class


