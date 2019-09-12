package a1;

import java.util.ArrayList;
import a1.ChessPiece.Color;

public class ChessBoard {
	
	private ChessPiece[][] board;
	private static int x=0;
	private static int y=0;
	
	/*
	 * Constructor to initialize the board with 8*8 ChessPieces
	 */
	ChessBoard() {
		
		board = new ChessPiece[8][8];
		
	}
	
	/*
	 * Places the ChessPiece at the initial position before the game begins
	 */
	public void initialize() {
		
		board[0][0] = new Rook(this, Color.WHITE);
		board[0][1] = new Knight(this, Color.WHITE);
		board[0][2] = new Bishop(this, Color.WHITE);
		board[0][3] = new Queen(this, Color.WHITE);
		board[0][4] = new King(this, Color.WHITE);
		board[0][5] = new Bishop(this, Color.WHITE);
		board[0][6] = new Knight(this, Color.WHITE);
		board[0][7] = new Rook(this, Color.WHITE);
		board[1][0] = new Pawn(this, Color.WHITE);
		board[1][1] = new Pawn(this, Color.WHITE);
		board[1][2] = new Pawn(this, Color.WHITE);
		board[1][3] = new Pawn(this, Color.WHITE);
		board[1][4] = new Pawn(this, Color.WHITE);
		board[1][5] = new Pawn(this, Color.WHITE);
		board[1][6] = new Pawn(this, Color.WHITE);
		board[1][7] = new Pawn(this, Color.WHITE);
		
		board[7][0]= new Rook(this, Color.BLACK);
		board[7][1] = new Knight(this, Color.BLACK);
		board[7][2] = new Bishop(this, Color.BLACK);
		board[7][3] = new Queen(this, Color.BLACK);
		board[7][4] = new King(this, Color.BLACK);
		board[7][5] = new Bishop(this, Color.BLACK);
		board[7][6] = new Knight(this, Color.BLACK);
		board[7][7] = new Rook(this, Color.BLACK);
		board[6][0] = new Pawn(this, Color.BLACK);
		board[6][1] = new Pawn(this, Color.BLACK);
		board[6][2] = new Pawn(this, Color.BLACK);
		board[6][3] = new Pawn(this, Color.BLACK);
		board[6][4] = new Pawn(this, Color.BLACK);
		board[6][5] = new Pawn(this, Color.BLACK);
		board[6][6] = new Pawn(this, Color.BLACK);
		board[6][7] = new Pawn(this, Color.BLACK);	
		
	}
	/*
	 * Returns the x-axis of the current chessPiece being referred.
	 */
	protected int getX() {
		return x;
	}
	
	/*
	 *  Returns the y-axis of the current chessPiece being referred.
	 */
	protected int getY() {
		return y;
	}

	/*
	 * Accepts x and y axis values.
	 * Returns true if the square is occupied by another ChessPiece
	 * Returns false if the square is null i.e not occupied by another ChessPiece
	 */
	protected boolean checkOccupied(int x, int y) {
		if(board[x][y] != null) {
			return true;
		}
		else
			return false;
		
	}
	
	/*
	 * Accepts a ChessPiece.
	 * Returns the location of that ChessPiece in terms of the x and y axis of where
	 * it is located on the board
	 * If ChessPiece is a null, it returns null
	 */
    protected ChessPiece getChessPiece(ChessPiece p) {
    	
    	if(p != null) {
    	for( int i = 0 ; i<8; i++) {
    		for(int j=0; j<8;j++) {
    			if(board[i][j] == p) {
    				x=i;
    				y=j;
    				
    			}
    		}
    	}
    	
    	return board[x][y];
    }
    	else 
    		return null;
    	
    }
   
    /*
     * Accepts x and y axis values 
     * Returns the ChessPiece at that x and y axis on the ChessBoard 
     * If no ChessPiece available at that location it returns null
     */
   protected ChessPiece getChessPieceBoard(int x, int y) {
    
	 ChessPiece p= null;
	 if(board[x][y] != null) {
    	for( int i = 0 ; i<8; i++) {
    		for(int j=0; j<8;j++) {
    			if(board[i][j] == board[x][y]) {
    				 p = board[x][y];			
    			}
    		}
        }
    	return p;
	 }
	 else 
		 return null;
    }
    
	/*
	 * Returns the color of the ChessPiece at x , y axis given as input
	 */
    protected Color getChessPieceColor (int x, int y) {
    	Color a = board[x][y].getColor();
    	return a;
    }
	
    /*
     * Returns if the given x and y axis values are outside the board.
     */
	protected boolean outsideBoard(int x, int y) {
		
		if (x < 0 || x > 7 || y < 0 || y > 7)
            return true;
        else
            return false;
    }

	
	/*
	 * Returns the string value of the x and y location
	 */
	protected String stringPosition (int x, int y) {
		
		char y_new= 'a';
		
		switch (y) {
		case 0: 
			y_new= 'a';
			break;
			
		case 1 : 
			y_new = 'b';
			break;
			
		case 2: 
			y_new = 'c';
			break;
			
		case 3:
			y_new = 'd';
			break;
			
		case 4:
			y_new = 'e';
			break;
			
		case 5:
			y_new = 'f';
			break;
			
		case 6:
			y_new='g';
			break;
			
		case 7:
			y_new= 'h';
			break;
			
		default:
			System.out.println("Wrong Input");
			
		
		}

		String pos = y_new + Integer.toString(x+1);
		return pos;
		
	}
	
	/*
	 * Returns the integer value of String position given as input
	 */
	protected int[] intPosition(String position){
		
		String[] parts = position.split("");
		int[] pos= new int[2];
		
		switch(parts[0]) {
		case "a":
			pos[1]= 0;
			break;
		
		case "b":
			pos[1]= 1;
			break;
		
		case "c":
			pos[1]= 2;
			break;
		
		case "d":
			pos[1]= 3;
			break;
			
		case "e":
			pos[1]= 4;
			break;
			
		case "f":
			pos[1] = 5;
		    break;
		   
		case "g":
			pos[1] = 6;
			break;
		
		case "h" : 
			pos[1] = 7;
			break;
		
		default:
					
			System.out.println("Wrong Input!!");
		}		
		
		pos[0] = (Integer.parseInt(parts[1]))-1;
	    
	    if( pos[0] > 9 || pos[0] < 0) {
	       System.out.println("Wrong Input!!");
	    }
		return pos;		
		
	}
	/*
	 * Accepts a string position of the Piece
	 * Throws an IllegalPositionException if the input position is outside the board.
	 * Returns the ChessPiece at the given position, and null if no ChessPiece present
	 */
	public ChessPiece getPiece(String position) throws IllegalPositionException {

		
		int[] piecePosition = intPosition(position);
		int x = piecePosition[0];
		int y = piecePosition[1];
		
		if(outsideBoard(x,y)) {
			throw new IllegalPositionException("This position is outside the board");
		}
		
		return board[x][y];
		
	}
	
	/*
	 * Accepts a ChessPiece and a position in string format
	 * Returns the true, if the ChessPiece is successfully moved from it's present position to the desired position
	 * Returns false if the ChessPiece is not moved from present position to the desired Position.
	 */
	public boolean placePiece(ChessPiece piece, String position) {
	
		getChessPiece(piece);
		String initialPos = stringPosition(x,y);
		
		try {
		 move(initialPos, position);
		 return true;
		}
		catch (IllegalMoveException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		
	}
	
	/*
	 * Accepts two positions in the string format
	 * Move the piece at the fromPosition to the toPositio
	 * If move is illegal, IllegalMove exception is thrown
	 * 
	 */
	public void move(String fromPosition, String toPosition) throws IllegalMoveException  {
		  
			int[] fromPos = intPosition(fromPosition);
			int[] toPos = intPosition(toPosition);
			
			//Verify if the toPostion is outside the board
			 if (outsideBoard(toPos[0], toPos[1])) {
				throw new IllegalMoveException("Outside the board");
			}
			 
			 //Verify if there is a piece at the fromPosition
			 try {
			 if(getPiece(fromPosition).equals(null)) {
				 throw new IllegalMoveException("There isn't a piece at that location");
			 }
			 } catch(IllegalPositionException e) {
				 System.out.println(e.getMessage());
			 }

			ChessPiece pieceToMove = board[fromPos[0]][fromPos[1]];

			ArrayList<String> legalMoves = pieceToMove.legalMoves();
			ChessPiece pieceAtDest = board[toPos[0]][toPos[1]];
			// Verifies if the piece at destination is not null
			if(pieceAtDest != null) {
				//Checks if the piece at fromPosition is from the same team of the piece at toPosition, if true raises an IllegalMoveException
				if(pieceAtDest.getColor() == pieceToMove.getColor()) {
					throw new IllegalMoveException("The location you chose to move your piece has another piece there from it's own team");
				}
				
				//If the two pieces are not from the same team, verify if the toPosition is a legal move for that piece
				//If true, piece is moved
				// if false, throws an IllegalMoveException
				else {
					boolean moveHappened = false;
					for (int i = 0; i < legalMoves.size(); i++) {
						if(legalMoves.get(i).contains(toPosition)) {
							board[fromPos[0]][fromPos[1]] = null;
							board[toPos[0]][toPos[1]] = pieceToMove;
							moveHappened = true;
						}
					}
					
					if(moveHappened == false) {
						throw new IllegalMoveException("This is not a valid move");
					}
					
				}
		  // If ChessPiece at the destination location is null, legal moves for the ChessPiece being moved to the destination location is checked
		  // if the destination position is in the legal moves of the piece at initial position piece is moved
		  // if it is not a legal move, throws an IllegalMoveException
		} else {	
			boolean moveHappened =false;
			for (int i = 0; i < legalMoves.size(); i++) {
				if(legalMoves.get(i).contains(toPosition)) {
					board[fromPos[0]][fromPos[1]] = null;
					board[toPos[0]][toPos[1]] = pieceToMove;
					moveHappened = true;
						
					}		
				}
				if(moveHappened == false) {
					throw new IllegalMoveException("This is not a valid move");
				}
		   }
		
	}
	
	/*
	 * Returns toString version of the ChessBoard
	 */
	public String toString(){
	    String chess="";
	    String upperLeft = "\u250C";
	    String upperRight = "\u2510";
	    String horizontalLine = "\u2500";
	    String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
	    String verticalLine = "\u2502";
	    String upperT = "\u252C";
	    String bottomLeft = "\u2514";
	    String bottomRight = "\u2518";
	    String bottomT = "\u2534";
	    String plus = "\u253C";
	    String leftT = "\u251C";
	    String rightT = "\u2524";

	    String topLine = upperLeft;
	    for (int i = 0; i<7; i++){
	        topLine += horizontal3 + upperT;
	    }
	    topLine += horizontal3 + upperRight;

	    String bottomLine = bottomLeft;
	    for (int i = 0; i<7; i++){
	        bottomLine += horizontal3 + bottomT;
	    }
	    bottomLine += horizontal3 + bottomRight;
	    chess+=topLine + "\n";

	    for (int row = 7; row >=0; row--){
	        String midLine = "";
	        for (int col = 0; col < 8; col++){
	            if(board[row][col]==null) {
	                midLine += verticalLine + " \u3000 ";
	                
	            } 
	            else {
	            	midLine += verticalLine + " "+board[row][col]+ " ";
	            }
	        }
	        midLine += verticalLine;
	        String midLine2 = leftT;
	        for (int i = 0; i<7; i++){
	            midLine2 += horizontal3 + plus;
	        }
	        midLine2 += horizontal3 + rightT;
	        chess+=midLine+ "\n";
	        if(row>=1)
	            chess+=midLine2+ "\n";
	    }

	    chess+=bottomLine;
	    
	    return chess;
	}



public static void main(String[] args) {
    ChessBoard board = new ChessBoard();
    board.initialize();
    System.out.println(board);
    try {
    	board.move("e7", "e5");
    	board.move("f7", "f5");
    	board.move("d7", "d5");
    	board.move("c7", "c5");
    	board.move("b7", "b5");
    	board.move("a7", "a5");
    	board.move("e8", "e7");
    	board.move("e7", "e6");
    	board.move("a2", "a4");
    	board.move("b2", "b4");
    	board.move("c2", "c4");
    	board.move("d2", "d4");
    	board.move("e2", "e4");
    	board.move("f2", "f4");
    	board.move("e1", "e2");
    	board.move("e2", "e3");
    	board.move("a5", "b4");
    	board.move("a4", "a5");
    	board.move("a5", "a6");
    	board.move("a6", "a7");
    	board.move("a1", "a2");
        System.out.println(board);
    }
    
    catch(IllegalMoveException e ) {
    	System.out.println(e.getMessage());
    }
  
    
  }
}
