package pt017.TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameLogic
{
	GameLogic(boolean a)
	{
		againstAI = a;
	}

	public boolean againstAI;
	private boolean roundPlayerOne = true;

	private int counter = 0;
	
	public String[][] gamePositions = new String[][]
	{
			{ "0", " " },
			{ "1", " " },
			{ "2", " " },
			{ "3", " " },
			{ "4", " " },
			{ "5", " " },
			{ "6", " " },
			{ "7", " " },
			{ "8", " " } 
	};

	public void placeSymbol()
	{
		System.out.println("Numbering scheme:");

		displayNumberingScheme(0);

		System.out.println("Game:");

		displayNumberingScheme(1);

		checkWinCondition();

	}
	
	public void displayNumberingScheme(int b)
	{
		boolean x = false;

		for (int i = 0; i < 9;)
		{
			if (x == false)
			{
				System.out.println(gamePositions[i][b] + "|" + gamePositions[i + 1][b] + "|" + gamePositions[i + 2][b]);
				x = true;
				i += 3;
			} else
			{
				System.out.println("-+-+-");
				x = false;
			}
		}
		System.out.println("");
	}
	
	public void checkWinCondition()
	{
		boolean gameOver = false;

		for (int i = 0; i < 9; i += 3) // Vertical
		{
			if (gamePositions[i][1] == gamePositions[i + 1][1] && gamePositions[i][1] == gamePositions[i + 2][1])
			{
				if (gamePositions[i][1] == "X")
				{
					GameMode over = new GameMode();

					over.winningMessage(MenuManagement.playerOne);
					gameOver = true;

					break;
				} else if (gamePositions[i][1] == "Y")
				{
					GameMode over = new GameMode();
					
					over.winningMessage(MenuManagement.playerTwo);
					gameOver = true;

					break;
				}
			}
		}

		if (gameOver == false)
		{
			for (int i = 0; i < 3; i++) // Horizontal
			{
				if (gamePositions[i][1] == gamePositions[i + 3][1] && gamePositions[i][1] == gamePositions[i + 6][1])
				{
					if (gamePositions[i][1] == "X")
					{
						GameMode over = new GameMode();

						over.winningMessage(MenuManagement.playerOne);
						gameOver = true;

						break;
					} else if (gamePositions[i][1] == "Y")
					{
						GameMode over = new GameMode();

						over.winningMessage(MenuManagement.playerTwo);
						gameOver = true;

						break;
					}
				}
			}
		}

		if (gameOver == false)
		{
			if (gamePositions[0][1] == gamePositions[4][1] && gamePositions[0][1] == gamePositions[8][1]) // Diagonal Top to Bottom
			{
				if (gamePositions[0][1] == "X")
				{
					GameMode over = new GameMode();
					
					over.winningMessage(MenuManagement.playerOne);
					gameOver = true;
				} else if (gamePositions[0][1] == "Y")
				{
					GameMode over = new GameMode();
					
					over.winningMessage(MenuManagement.playerTwo);
					gameOver = true;
				}
			}
		}
		
		if(gameOver == false)
		{
			if (gamePositions[2][1] == gamePositions[4][1] && gamePositions[2][1] == gamePositions[6][1]) // Diagonal Bottom to Top
			{
				if (gamePositions[2][1] == "X")
				{
					GameMode over = new GameMode();

					over.winningMessage(MenuManagement.playerOne);
					gameOver = true;
				} else if (gamePositions[2][1] == "Y")
				{
					GameMode over = new GameMode();

					over.winningMessage(MenuManagement.playerTwo);
					gameOver = true;
				}
			}
		}

		if (gameOver == false && counter < 9)
		{
			counter++;
			
			if(againstAI == true && roundPlayerOne == false)
			{
				aiTurn();
			}
			else
			{
				inputNextField();
			}
		}
		else
		{
			GameMode over = new GameMode();

			over.winningMessage("Nobody");
			gameOver = true;
		}
	}

	public void inputNextField()
	{
		try
		{
			Scanner input = new Scanner(System.in);

			if (roundPlayerOne == true)
			{
				System.out.println(MenuManagement.playerOne + ", please enter next field's number:");

				int nextField = Integer.parseInt(input.nextLine());

				if (gamePositions[nextField][1] == " ")
				{
					gamePositions[nextField][1] = "X";
					roundPlayerOne = false;

					placeSymbol();
				} else
				{
					invalidInput();
				}
			} else
			{
				System.out.println(MenuManagement.playerTwo + ", please enter next field's number:");

				int nextField = input.nextInt();

				if (gamePositions[nextField][1] == " ")
				{
					gamePositions[nextField][1] = "Y";
					roundPlayerOne = true;

					placeSymbol();
				} else
				{
					invalidInput();
				}
			}
		} catch (Exception e)
		{
			invalidInput();
		}
	}
	
	public void aiTurn()
	{
		int randomPos = ThreadLocalRandom.current().nextInt(0, 9);
		
		if(gamePositions[randomPos][1] != " ")
		{
			for(int a = randomPos; a < 8; a++)
			{
				if(gamePositions[a][1] == " ")
				{
					randomPos = a;
					break;
				}
			}
			
			for(int a = randomPos; a < 8; a--)
			{
				if(gamePositions[a][1] == " ")
				{
					randomPos = a;
					break;
				}
			}
		}
		
		gamePositions[randomPos][1] = "Y";
		roundPlayerOne = true;
		
		System.out.println("");
		System.out.println(MenuManagement.playerTwo + " decided to place his symbol on field nr. " + randomPos);
		System.out.println("");
		
		placeSymbol();

	}
	
	public void invalidInput()
	{
		System.out.println("");
		System.out.println("Invalid Input. Please try again.");

		inputNextField();
	}
}
