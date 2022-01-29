/*
  
  		This class represents a chess board.
  	it has a 2d array of tiles. Which represent
  	all tiles in the board. Thus, constituting
  	a has-a relationship.
  
 */

import java.io.*; 	// For file reading
import java.util.*; // For scanner

public class Board {
	
	Tile[][] tiles = new Tile[8][8];	
	Tile genericTile = new Tile();
	
	// This is the default constructor. 
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	  
	  		This constructor method, takes the name of
	  	board we are going to control and calculate.
	  	Then it initializes all tiles in the board with
	  	default values of a generic tile. 
	  	Then reads each tile or piece one by one and
	  	updates tiles by the read value. if the file can't
	  	be found. it throws an exception, prints the 
	  	suitable message and then, terminates. 
	  
	 */
	
	public Board(String s) {
		
		int countLine,countCol;
		
		for(countLine=0;countLine<8;countLine++) {
			
			for(countCol=0;countCol<8;countCol++) {
				
				tiles[countLine][countCol] = genericTile;
				
			}
			
		}
		
		try {
			
			File file = new File(s+".txt");
			Scanner fileScanner = new Scanner(file);
			
			for(countLine = 0;countLine < 8;countLine++) {
				
				for(countCol = 0;countCol < 8;countCol++) {
						
						tiles[countLine][countCol] = new Tile(fileScanner.next());
		
				}
				
			}
			
			fileScanner.close();
			
		}
		
		catch(FileNotFoundException fnfe){
			
			System.out.println(fnfe.getMessage());
			System.exit(0);
			
		}
		
	}
	
	/*
	  
	  		This method, calculates both score of blacks
	  	and whites. At the beginning, it traverses all the
	  	board to look every piece to determine which pieces
	  	are being threatened or is there any piece threatened 
	  	by the piece being controlled (only pawns, queens and
	  	knights being controlled). if a threatened piece
	  	is found, then the value of it's isThreatened attribute
	  	is updated to true. Then, the method proceeds to move
	  	through the board a second time. But, this time it
	  	does this to calculate score of blacks and whites.
	  	While, traversing the board it calculates both scores
	  	simultaneously. After calculating scores, it prints
	  	both scores.
	  
	 */
	
	public void calculate() {
		
		int count,countLine,countCol,x,y;
		double blacks=0,whites=0;
		
		for(countLine = 0;countLine < 8;countLine++) {
			
			for(countCol = 0;countCol < 8;countCol++) {
				
				if(tiles[countLine][countCol].isBlank == false) {
					
					if(tiles[countLine][countCol].piece == 'v') {
						
						for(y = countLine-1,x = countCol-1;y>=0 && y<8 && x>=0 && x<8;x--,y--) {
							
								
							if(tiles[countLine][countCol].color == tiles[y][x].color) {
									
								break;
									
							}
								
							else if(tiles[countLine][countCol].color != tiles[y][x].color && tiles[y][x].isBlank == false ) {
									
								tiles[y][x].updateThreatStatus();
								break;
									
							}
								
						}
						
						for(y = countLine+1,x = countCol-1;y>=0 && y<8 && x>=0 && x<8;x--,y++) {
							
							
							if(tiles[countLine][countCol].color == tiles[y][x].color) {
									
								break;
									
							}
								
							else if(tiles[countLine][countCol].color != tiles[y][x].color && tiles[y][x].isBlank == false ) {
									
								tiles[y][x].updateThreatStatus();
								break;
									
							}
								
						}								
						
						for(y = countLine-1,x = countCol+1;y>=0 && y<8 && x>=0 && x<8;x++,y--) {
							
							
							if(tiles[countLine][countCol].color == tiles[y][x].color) {
									
								break;
									
							}
								
							else if(tiles[countLine][countCol].color != tiles[y][x].color && tiles[y][x].isBlank == false ) {
									
								tiles[y][x].updateThreatStatus();
								break;
									
							}
								
						}
						
						for(y = countLine+1,x = countCol+1;y>=0 && y<8 && x>=0 && x<8;x++,y++) {
							
							
							if(tiles[countLine][countCol].color == tiles[y][x].color) {
									
								break;
									
							}
								
							else if(tiles[countLine][countCol].color != tiles[y][x].color && tiles[y][x].isBlank == false ) {
									
								tiles[y][x].updateThreatStatus();
								break;
									
							}
								
						}
						
						for(y = countLine+1;y>=0 && y<8;y++) {
							
							if(tiles[countLine][countCol].color == tiles[y][countCol].color) {
								
								break;
									
							}
								
							else if(tiles[countLine][countCol].color != tiles[y][countCol].color && tiles[y][countCol].isBlank == false ) {
									
								tiles[y][countCol].updateThreatStatus();
								break;
									
							}
							
						}
						
						for(y = countLine-1;y>=0 && y<8;y--) {
							
							if(tiles[countLine][countCol].color == tiles[y][countCol].color) {
								
								break;
									
							}
								
							else if(tiles[countLine][countCol].color != tiles[y][countCol].color && tiles[y][countCol].isBlank == false ) {
									
								tiles[y][countCol].updateThreatStatus();
								break;
									
							}
							
						}
						
						for(x = countCol+1;x>=0 && x<8;x++) {
							
							if(tiles[countLine][countCol].color == tiles[countLine][x].color) {
								
								break;
									
							}
								
							else if(tiles[countLine][countCol].color != tiles[countLine][x].color && tiles[countLine][x].isBlank == false ) {
									
								tiles[countLine][x].updateThreatStatus();
								break;
									
							}
							
						}
						
						for(x = countCol-1;x>=0 && x<8;x--) {
							
							if(tiles[countLine][countCol].color == tiles[countLine][x].color) {
								
								break;
									
							}
								
							else if(tiles[countLine][countCol].color != tiles[countLine][x].color && tiles[countLine][x].isBlank == false ) {
									
								tiles[countLine][x].updateThreatStatus();
								break;
									
							}
							
						}
						
					}
					
					else if(tiles[countLine][countCol].piece == 'a') {
						
						for(count=0;count<8;count++) {
						
							if(count==0 && countLine+1<8 && countCol+2<8 && tiles[countLine][countCol].color != tiles[countLine+1][countCol+2].color && tiles[countLine+1][countCol+2].isBlank == false ) {
							
								tiles[countLine+1][countCol+2].updateThreatStatus();
								
							}
						
							else if(count==1 && countLine+1<8 && countCol-2>=0 && tiles[countLine][countCol].color != tiles[countLine+1][countCol-2].color && tiles[countLine+1][countCol-2].isBlank == false ) {
							
								tiles[countLine+1][countCol-2].updateThreatStatus();
								
							}
						
							else if(count==2 && countLine-1>=0 && countCol+2<8 && tiles[countLine][countCol].color != tiles[countLine-1][countCol+2].color && tiles[countLine-1][countCol+2].isBlank == false ) {
							
								tiles[countLine-1][countCol+2].updateThreatStatus();
								
							}
						
							else if(count==3 && countLine-1>=0 && countCol-2>=0 && tiles[countLine][countCol].color != tiles[countLine-1][countCol-2].color && tiles[countLine-1][countCol-2].isBlank == false ) {
							
								tiles[countLine-1][countCol-2].updateThreatStatus();
								
							}
						
							else if(count==4 && countLine+2<8 && countCol+1<8 && tiles[countLine][countCol].color != tiles[countLine+2][countCol+1].color && tiles[countLine+2][countCol+1].isBlank == false ) {
							
								tiles[countLine+2][countCol+1].updateThreatStatus();
								
							}
						
							else if(count==5 && countLine+2<8 && countCol-1>=0 && tiles[countLine][countCol].color != tiles[countLine+2][countCol-1].color && tiles[countLine+2][countCol-1].isBlank == false ) {
							
								tiles[countLine+2][countCol-1].updateThreatStatus();
								
							}
						
							else if(count==6 && countLine-2>=0 && countCol-1>=0 && tiles[countLine][countCol].color != tiles[countLine-2][countCol-1].color && tiles[countLine-2][countCol-1].isBlank == false ) {
							
								tiles[countLine-2][countCol-1].updateThreatStatus();
								
							}
						
							else if(count==7 && countLine-2>=0 && countCol+1<8 && tiles[countLine][countCol].color != tiles[countLine-2][countCol+1].color && tiles[countLine-2][countCol+1].isBlank == false ) {
							
								tiles[countLine-2][countCol+1].updateThreatStatus();
								
							}
						
						}
						
					}
					
					else if(tiles[countLine][countCol].color == 'b') {
						
						if(tiles[countLine][countCol].piece == 'p') {
							
							for(count=0;count<2;count++){
							
								if(count==0 && countLine-1>=0 && countCol-1>=0 && tiles[countLine][countCol].color != tiles[countLine-1][countCol-1].color && tiles[countLine-1][countCol-1].isBlank == false ) {
								
									tiles[countLine-1][countCol-1].updateThreatStatus();
								
								}
							
								else if(count==1 && countLine-1>=0 && countCol+1<8 && tiles[countLine][countCol].color != tiles[countLine-1][countCol+1].color && tiles[countLine-1][countCol+1].isBlank == false ) {
								
									tiles[countLine-1][countCol+1].updateThreatStatus();
								
								}
							
							}	
								
						}
						
					}
					
					else if(tiles[countLine][countCol].color == 's') {
						
						if(tiles[countLine][countCol].piece == 'p') {
							
							for(count=0;count<2;count++) {
							
								if(count==0 && countLine+1<8 && countCol-1>=0 && tiles[countLine][countCol].color != tiles[countLine+1][countCol-1].color && tiles[countLine+1][countCol-1].isBlank == false ) {
								
									tiles[countLine+1][countCol-1].updateThreatStatus();
								
								}
							
								else if(count==1 && countLine+1<8 && countCol+1<8 && tiles[countLine][countCol].color != tiles[countLine+1][countCol+1].color && tiles[countLine+1][countCol+1].isBlank == false ) {
								
									tiles[countLine+1][countCol+1].updateThreatStatus();
								
								}
							
							}	
								
						}
						
					}
					
				}
				
			}
			
		}
		
		for(countLine = 0;countLine < 8 ;countLine++) {
			
			for(countCol = 0;countCol < 8;countCol++) {
				
				if(tiles[countLine][countCol].color == 'b') {
					
					if(tiles[countLine][countCol].piece == 'p' && tiles[countLine][countCol].isThreatened == true) {
						
						whites = whites+0.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'p' && tiles[countLine][countCol].isThreatened == false) {
						
						whites = whites+1;
						
					}
					
					if(tiles[countLine][countCol].piece == 'a' && tiles[countLine][countCol].isThreatened == true) {
						
						whites = whites+1.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'a' && tiles[countLine][countCol].isThreatened == false) {
						
						whites = whites+3;
						
					}
					
					if(tiles[countLine][countCol].piece == 'f' && tiles[countLine][countCol].isThreatened == true) {
						
						whites = whites+1.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'f' && tiles[countLine][countCol].isThreatened == false) {
						
						whites = whites+3;
						
					}
					
					if(tiles[countLine][countCol].piece == 'k' && tiles[countLine][countCol].isThreatened == true) {

						whites = whites+2.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'k' && tiles[countLine][countCol].isThreatened == false) {
						
						whites = whites+5;
						
					}
					
					if(tiles[countLine][countCol].piece == 'v' && tiles[countLine][countCol].isThreatened == true) {
						
						whites = whites+4.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'v' && tiles[countLine][countCol].isThreatened == false) {
						
						whites = whites+9;
						
					}
					
					if(tiles[countLine][countCol].piece == 's' && tiles[countLine][countCol].isThreatened == true) {
						
						whites = whites+50;
						
					}
					
					else if(tiles[countLine][countCol].piece == 's' && tiles[countLine][countCol].isThreatened == false) {
						
						whites = whites+100;
						
					}
					
				}
				
				else if(tiles[countLine][countCol].color == 's') {
					
					if(tiles[countLine][countCol].piece == 'p' && tiles[countLine][countCol].isThreatened == true) {
						
						blacks = blacks+0.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'p' && tiles[countLine][countCol].isThreatened == false) {
						

						blacks = blacks+1;
						
					}
					
					if(tiles[countLine][countCol].piece == 'a' && tiles[countLine][countCol].isThreatened == true) {
						
						blacks = blacks+1.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'a' && tiles[countLine][countCol].isThreatened == false) {
						
						blacks = blacks+3;
						
					}
					
					if(tiles[countLine][countCol].piece == 'f' && tiles[countLine][countCol].isThreatened == true) {
						
						blacks = blacks+1.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'f' && tiles[countLine][countCol].isThreatened == false) {
						
						blacks = blacks+3;
						
					}
					
					if(tiles[countLine][countCol].piece == 'k' && tiles[countLine][countCol].isThreatened == true) {
						
						blacks = blacks+2.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'k' && tiles[countLine][countCol].isThreatened == false) {
						
						blacks = blacks+5;
						
					}
					
					if(tiles[countLine][countCol].piece == 'v' && tiles[countLine][countCol].isThreatened == true) {
						
						blacks = blacks+4.5;
						
					}
					
					else if(tiles[countLine][countCol].piece == 'v' && tiles[countLine][countCol].isThreatened == false) {
						
						blacks = blacks+9;
						
					}
					
					if(tiles[countLine][countCol].piece == 's' && tiles[countLine][countCol].isThreatened == true) {

						blacks = blacks+50;
						
					}
					
					else if(tiles[countLine][countCol].piece == 's' && tiles[countLine][countCol].isThreatened == false) {
						
						blacks = blacks+100;
						
					}
					
				}
				
			}
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Blacks: "+blacks);
		System.out.println("Whites: "+whites);
		
	}
	
}
