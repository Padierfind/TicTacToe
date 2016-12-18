package pt017.TicTacToe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class App 
{

	public static void main( String[] args ) 
	{
		MenuManagement menMan= new MenuManagement();
		menMan.menu();
	}

}
