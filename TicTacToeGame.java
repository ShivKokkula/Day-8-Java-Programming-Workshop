package tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {

	static Scanner userInput = new Scanner(System.in);
	static char userChoice;
	static char compChoice;

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe Game !!!");
		char[][] board = { { ' ', '|', ' ', '|', ' ' }, 
						   { '-', '+', '-', '+', '-' }, 
						   { ' ', '|', ' ', '|', ' ' },
						   { '-', '+', '-', '+', '-' }, 
						   { ' ', '|', ' ', '|', ' ' } };
		showBoard(board);
		selectUserChoice();
		selectPosition(board);
		showBoard(board);

	}

	public static void showBoard(char[][] board) {
		for (char[] row : board) {
			for (char column : row) {
				System.out.print(column);
			}
			System.out.println();
		}
	}

	public static void selectPosition(char[][] board) {
		System.out.println("Enter your placement(0-9):");
		int pos = userInput.nextInt();
		switch (pos) {
		case 1:
			board[0][0] = 'X';
			break;
		case 2:
			board[0][2] = 'X';
			break;
		case 3:
			board[0][4] = 'X';
			break;
		case 4:
			board[2][0] = 'X';
			break;
		case 5:
			board[2][2] = 'X';
			break;
		case 6:
			board[2][4] = 'X';
			break;
		case 7:
			board[4][0] = 'X';
			break;
		case 8:
			board[4][2] = 'X';
			break;
		case 9:
			board[4][4] = 'X';
			break;
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
