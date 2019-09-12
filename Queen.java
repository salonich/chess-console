package a1;

import java.util.ArrayList;

public class Queen extends ChessPiece{
	
	private static final String whiteQueen = "\u2655";
	private static final String blackQueen = "\u265B";
	
	/*
	 * Constructor to initialize ChessPiece with a board and Color
	 */
	public Queen(ChessBoard board, Color color) {
		super(board, color);
	}
	
	/*
	 * Returns the string for unicode White Queen and Black Queen
	 */
	public String toString() {
		if(getColor() == Color.WHITE)
		   return whiteQueen.toString();
		else if(getColor() == Color.BLACK)
			return blackQueen.toString();
		else
			return null;
	}
	
	/*
	 * Returns an ArrayList for the legalMoves Queen can make from the current position
	 * Returns an empty ArrayList if no legal moves available.
	 * Queen cannot move in this game no no legal moves.
	 */
    public ArrayList<String> legalMoves(){
		
		ArrayList<String> queenMoves = new ArrayList<>();
		return queenMoves;
	}
	
	
	

}
