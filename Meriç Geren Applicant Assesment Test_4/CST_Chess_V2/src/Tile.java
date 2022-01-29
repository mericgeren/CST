/* 
 
	This class represents tiles in a chess board.
	
	String type attribute content represents content
of the tile in the board that we read from a text file.
  	
  	Char attributes of piece and color represents color 
and type of the piece.
  	
  	Boolean attribute isThreated shows if the piece is
threatened by pawns, horses or by the queen or not.
  	
  	Boolean attribute isBlank shows if there is a piece
on the tile or it's empty.
  	
*/

public class Tile {
	
	public String content;
	public char piece,color;
	public boolean isThreatened = false,isBlank = true;
	
	/* 
	
			This constructor is the default constructor.
		initializes the tile with default values. Thus,
		evading from NullPointerException
	
	 */
	public Tile() {
		
		this.content = "--";
		this.piece = this.content.charAt(0);
		this.color = this.content.charAt(1);
		isBlank = true;
		isThreatened = false;
		
	}
	
	/*  	
	    	
	    	This constructor takes content of the tile as parameter then,
	 	extracts type and color of piece from it. At the last, checks if
	 	the tile is empty and updates isBlank accordingly.
	
	*/
	
	public Tile(String content) {
		
		this.content = content;
		this.piece = this.content.charAt(0);
		this.color = this.content.charAt(1);
		
		if(this.piece != '-' && this.color != '-') {
			
			isBlank = false;
			isThreatened = false;
			
		}
		
		else {
			
			isBlank = true;
			isThreatened = false;
			
		}
		
	}
	
	/*
	  
	  		This method updates piece type, color and
	  	isBlank according to content of the tile.
	  
	 */
	
	public void update() {
		
		this.piece = this.content.charAt(0);
		this.color = this.content.charAt(1);
		
		if(this.piece != '-' && this.color != '-') {
			
			isBlank = false;
			isThreatened = false;
			
		}
		
		else {
			
			isBlank = true;
			isThreatened = false;
			
		}
		
	}
	
	/*
	 
	 		Updates the threat status of
	 	a tile in relation to if the tile
	 	is threatened by a queen, a pawn
	 	or a knight. 
	  
	 */
	
	public void updateThreatStatus() {
		
		isThreatened = true;
		
	}
	
	/*
	  
	  		This method checks if the tile is empty
	  	and updates isBlank.
	  
	 */
	
	public void checkIfBlank() {
		
		if(this.piece != '-' && this.color != '-') {
			
			isBlank = false;
			isThreatened = false;
			
		}
		
		else {
			
			isBlank = true;
			isThreatened = false;
			
		}
		
		
	}
	
}
