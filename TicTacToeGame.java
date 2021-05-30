package tictactoegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	static Scanner userInput = new Scanner(System.in);
	static char userChoice;
	static char compChoice;
	static Random rand = new Random();
	static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
	static boolean win = false;
	static int numOfTurns = 0;

	public static void main(String[] args) {
		int playerPos;
		System.out.println("Welcome to Tic-Tac-Toe Game !!!");
		char[][] board = { { ' ', '|', ' ', '|', ' ' }, 
						   { '-', '+', '-', '+', '-' }, 
						   { ' ', '|', ' ', '|', ' ' },
						   { '-', '+', '-', '+', '-' }, 
						   { ' ', '|', ' ', '|', ' ' } };
		showBoard(board);
		selectUserChoice();
		while (!win & numOfTurns<=9) {
			System.out.println("Enter your placement(0-9):");
			playerPos = userInput.nextInt();
			playerPosition.add(playerPos);
			selectPosition(board, playerPos, userChoice);
			showBoard(board);
			System.out.println(checkWinner());
			playerPos = rand.nextInt(9) + 1;
			cpuPosition.add(playerPos);
			selectPosition(board, playerPos, compChoice);
			showBoard(board);
			System.out.println(checkWinner());
		}
	}

	public static void showBoard(char[][] board) {
		for (char[] row : board) {
			for (char column : row) {
				System.out.print(column);
			}
			System.out.println();
		}
	}

	public static void selectPosition(char[][] board, int pos, char symbol) {
		switch (pos) {
		case 1:
			board[0][0] = symbol;
			break;
		case 2:
			board[0][2] = symbol;
			break;
		case 3:
			board[0][4] = symbol;
			break;
		case 4:
			board[2][0] = symbol;
			break;
		case 5:
			board[2][2] = symbol;
			break;
		case 6:
			board[2][4] = symbol;
			break;
		case 7:
			board[4][0] = symbol;
			break;
		case 8:
			board[4][2] = symbol;
			break;
		case 9:
			board[4][4] = symbol;
			break;
		default:
			break;
		}
		numOfTurns++;
	}

	public static String checkWinner() {
		List topRow = Arrays.asList(1, 2, 3);
		List midddleRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List leftColumn = Arrays.asList(1, 4, 7);
		List midddleColumn = Arrays.asList(2, 5, 8);
		List rightColumn = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(3, 5, 7);

		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(midddleRow);
		winningConditions.add(bottomRow);
		winningConditions.add(leftColumn);
		winningConditions.add(midddleColumn);
		winningConditions.add(rightColumn);
		winningConditions.add(cross1);
		winningConditions.add(cross2);

		for (List l : winningConditions) {
			if (playerPosition.containsAll(l)) {
				win = true;
				return "Congratulation you won!";
			} else if (cpuPosition.containsAll(l)) {
				win = true;
				return "CPU wins!";
			} else if (playerPosition.size() + cpuPosition.size() == 9)
				return "Match Tie";
		}
		return "";
	}

	public static void selectUserChoice() {
		System.out.println("Please choose from X or O");
		userChoice = userInput.next().charAt(0);

		if (userChoice == 'X')
			compChoice = 'O';
		else
			compChoice = 'X';

		System.out.println("Payer choice is: " + userChoice + " and computer's will be " + compChoice);
	}

}
