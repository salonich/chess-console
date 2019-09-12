package a1;

import java.util.ArrayList;

public class Rook extends ChessPiece {

	private static final String whiteRook = "\u2656";
	private static final String blackRook = "\u265C" ;
	
	/*
	 * Constructor to initialize ChessPiece on a board and with a color(Black or white)
	 * Takes the value of the ChessPiece class(super)
	 */
	public Rook(ChessBoard board, Color color) {
		super(board, color);
	}
	
	/*
	 * Returns the String version of the unicode White Rook or Black Rook
	 */
	public String toString() {
		if(getColor() == Color.WHITE)
		   return whiteRook.toString();
		else if(getColor() == Color.BLACK)
			return blackRook.toString();
		else
			return null;
	}
	
	/*
	 * Returns an ArrayList with all the legal moves the Rook can make from the current location
	 * Returns an empty ArrayList if no legal moves available.
	 * A rook can move any number of squares horizontally or vertically, forward or backward, 
	 * as long as it does not have to leap over other pieces. 
	 * At the end of the move, it can occupy a previously empty square or capture (replace) an opponent's piece
	 *  but it cannot replace another piece of the same player.
	 */
	
   public ArrayList<String> legalMoves(){
		
		ArrayList<String> rookMoves = new ArrayList<>();
		ChessPiece p = board.getChessPiece(this);
		int x = board.getX();
		int y = board.getY();
		
		 verticalDownLegalMove(rookMoves, p, x, y);
		 
		 verticalUpLegalMove(rookMoves, p, x, y);
		 
		 leftLegalMove(rookMoves, p, x, y);
		 
		 rightLegalMove(rookMoves, p, x, y);
		
		return rookMoves;
	}
   
   /*
    * Returns the list of legal Moves for Rook to move right
    */

	private void rightLegalMove(ArrayList<String> rookMoves, ChessPiece p, int x, int y) {
		for (int i = y + 1; board.outsideBoard(x, i)== false ; i++) {
			 if(!board.checkOccupied(x, i)) {
				String position = board.stringPosition(x, i);
				rookMoves.add(position);
			} else if(board.getChessPiece(p).getColor() != board.getChessPieceColor(x, i)) {
				String position = board.stringPosition(x, i);
				rookMoves.add(position);
				break;
			} else
				break; 
        }
	}
	/*
	 * Returns the list of legal Moves for Rook to move left
	 */
	private void leftLegalMove(ArrayList<String> rookMoves, ChessPiece p, int x, int y) {
		for (int i = y - 1; board.outsideBoard(x, i)== false ; i--) {
			 if(!board.checkOccupied(x,i)) {
				String position = board.stringPosition(x, i);
				rookMoves.add(position);
			} else if(board.getChessPiece(p).getColor() != board.getChessPieceColor(x, i)) {
				String position = board.stringPosition(x, i);
				rookMoves.add(position);
				break;
			} else
				break; 
        }
	}
    /*
     * Returns the list of legal Moves for Rook to move vertically up
     */
	private void verticalUpLegalMove(ArrayList<String> rookMoves, ChessPiece p, int x, int y) {
		for (int i = x - 1; board.outsideBoard(i, y)== false ; i--) {
			 if(!board.checkOccupied(i, y)) {
				String position = board.stringPosition(i, y);
				rookMoves.add(position);
			} else if(board.getChessPiece(p).getColor() != board.getChessPieceColor(i,y)) {
				String position = board.stringPosition(i, y);
				rookMoves.add(position);
				break;
			} else
				break; 
        }
	}
	
	/*
	 * Returns the list of legal Moves for Rook to vertically down
	 */

	private void verticalDownLegalMove(ArrayList<String> rookMoves, ChessPiece p, int x, int y) {
		for (int i = x + 1; board.outsideBoard(i, y)== false ; i++) {
			 if(!board.checkOccupied(i, y)) {
				String position = board.stringPosition(i, y);
				rookMoves.add(position);
			} else if(board.getChessPiece(p).getColor() != board.getChessPieceColor(i,y)) {
				String position = board.stringPosition(i, y);
				rookMoves.add(position);
				break;
			} else
				break; 
        }
	}
	
}
