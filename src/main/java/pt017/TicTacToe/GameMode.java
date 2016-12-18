package pt017.TicTacToe;

import java.util.Scanner;

public class GameMode
{

	public void winningMessage(String winner)
	{
		System.out.println(winner + " won!");
		System.out.println("Go back to menu: 0");
		System.out.println("Exit game: 1");
		
		inputAfterGame();
	}
	
	public void inputAfterGame()
	{
		Scanner input = new Scanner(System.in);

		try{
			int i = input.nextInt();
			
			if(i == 0)
			{
				MenuManagement menMan= new MenuManagement();
				menMan.menu();
			}
			else if(i == 1)
			{
				System.out.println("Thanks for playing!");
				System.exit(0);
			}
			else
			{
				System.out.println("Invalid Input. Please try again.");
				inputAfterGame();
			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input. Please try again.");
			inputAfterGame();
		}	
	}

}
