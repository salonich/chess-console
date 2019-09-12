package a1;

import java.util.ArrayList;

public class Knight extends ChessPiece {
	
	private static final String whiteKnight = "\u2658" ;
	private static final String blackKnight = "\u265E";
	
	/*
	 * Constructor to initialize ChessPiece with a board and Color
	 */
	public Knight (ChessBoard board, Color color) {
		super(board, color);
	}
	/*
	 * Returns string of the unicode White Knight and Black Knight
	 */
	public String toString() {
		if(getColor() == Color.WHITE)
		   return whiteKnight.toString();
		else if(getColor() == Color.BLACK)
			return blackKnight.toString();
		else 
			return null;
	}
	
	/*
	 * Returns the legal Moves for Knight from the current location
	 * Returns an empty ArrayList if no legal moves available.
	 * Knight cannot move in this game so no legal moves
	 */
    public ArrayList<String> legalMoves(){
		
		ArrayList<String> knightMoves = new ArrayList<>();
		return knightMoves;
	}

}
