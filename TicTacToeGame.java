package tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
	
	static Scanner userInput = new Scanner(System.in);
	static char userChoice;
	static char compChoice;

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe Game !!!");
		board();
		selectUserChoice();
	}
	
	public static void board() {
		
		char board[] = new char[10];
		
		for(int i=0; i<10; i++) {
			board[i] = ' ';
	     }
		
	}
	
	public static void selectUserChoice() {
		System.out.println("Please choose from X or O");
		userChoice = userInput.next().charAt(0);

		if (userChoice == 'X')
			compChoice = 'O';
		else
			compChoice = 'X';
		
		System.out.println("User is: " + userChoice + " computer is " + compChoice);
	}

}
