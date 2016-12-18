package pt017.TicTacToe;

import java.util.Scanner;

public class MenuManagement
{
	
	public static String playerOne;
	public static String playerTwo;
	
	public GameLogic logic;

	public void menu() 
	{
		System.out.println("Welcome to Tic Tac Toe");
		System.out.println(" ");
		System.out.println("Please choose a gamemode:");
		System.out.println("0: Human vs. Human");
		System.out.println("1: Human vs. Computer");

		menuInput();
	}
	
	public void menuInput() 
	{
		Scanner input = new Scanner(System.in);
		
		try{
			int i = input.nextInt();
			
			if(i == 0)
			{
				System.out.println("Please enter a name for Player One:");
				playerOne = input.next();

				System.out.println("Please enter a name for Player Two:");
				playerTwo = input.next();

				logic = new GameLogic(false);
				logic.placeSymbol();
			}
			else if(i == 1)
			{
				System.out.println("Please enter your name:");
				playerOne = input.next();
				playerTwo = "Computer";

				logic = new GameLogic(true);
				logic.placeSymbol();
			}
			else
			{
				System.out.println("Invalid Input. Please try again.");
				menuInput();
			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input. Please try again.");
			menuInput();
		}
	}

}
