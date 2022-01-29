/*
  
  		This is the runner class. in other words,
  	it's the place where the magic happens. At the 
  	beginning, it takes name of the board to be 
  	calculated from the user. User doesn't need to
  	write ".txt" extension. The program automatically
  	appends the extension for user. Then creates and 
  	reads the board from the file. Then calculates
  	scores of blacks and whites.
  
 */

import java.util.*;  // For scanner

public class CSTRunner {

	public CSTRunner() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) {
		
		String boardName;
		System.out.print("Please enter the board you want to be calculated:");
		Scanner userScanner = new Scanner(System.in);
		boardName = userScanner.next();
		userScanner.close();
		
		Board theBoard = new Board(boardName);
		theBoard.calculate();
		
	}
	
}
