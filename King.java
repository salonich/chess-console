package a1;

import java.util.ArrayList;

public class King extends ChessPiece{
	
	private static final String whiteKing = "\u2654";     
    private static final String blackKing = "\u265A";

	/*
	 * Constructor to initialize ChessPiece with a board and Color
	 */
	public King(ChessBoard board, Color color) {
		super(board, color);
	}
	
	/*
	 * Returns the string of the unicode White King or Black King
	 */
	public String toString() {
		if(getColor() == Color.WHITE)
		   return whiteKing.toString();
		else if(getColor() == Color.BLACK)
			return blackKing.toString();
		else
			return null;
	}
	
	
	/*
	 * Returns the legal moves for King from the current location.
	 * Returns an empty ArrayList if no legal moves available.
	 * The king can only move one square horizontally, vertically, or diagonally.
	 * Assume that it cannot castle.
	 */
	public ArrayList<String> legalMoves(){
		
		ArrayList<String> kingMoves = new ArrayList<>();
		
		ChessPiece p = board.getChessPiece(this);
		int x = board.getX();
		int y = board.getY();	
		
		// moves for White king
		if(p.getColor() == Color.WHITE) {
			
			// move the piece horizontally right
			if(board.checkOccupied(x, y+1) || board.outsideBoard(x, y+1)) {
			}
			else {
				String legal_moves = board.stringPosition(x, y+1);
				kingMoves.add(legal_moves);	
			}
			
			//to move the piece horizontally left
			if(board.checkOccupied(x, y-1) || board.outsideBoard(x, y-1)) {
			}
			else {
				String legal_moves = board.stringPosition(x, y-1);
				kingMoves.add(legal_moves);	
			}
			
			
			//move the piece vertically up
			if(board.checkOccupied(x+1, y) || board.outsideBoard(x+1, y)) {
			}
			else {
				String legal_moves = board.stringPosition(x+1, y);
				kingMoves.add(legal_moves);	
			}
			//move the piece vertically down
			if(board.outsideBoard(x-1, y) ||  board.checkOccupied(x-1, y) ) {
			
			} else {
				String legal_moves = board.stringPosition(x-1, y);
				kingMoves.add(legal_moves);	
			}
			
			
			//move the piece diagonally left up
			if(board.checkOccupied(x+1, y-1) || board.outsideBoard(x+1, y-1)) {
			}
			else {
				String legal_moves = board.stringPosition(x+1, y-1);
				kingMoves.add(legal_moves);	
			}
			
			//move the piece diagonally left down
			if(board.outsideBoard(x-1, y-1) || board.checkOccupied(x-1, y-1)) {
			}
			else {
				String legal_moves = board.stringPosition(x-1, y-1);
				kingMoves.add(legal_moves);	
			}
			
			//move the piece diagonally right up
			if(board.checkOccupied(x+1, y+1) || board.outsideBoard(x+1, y+1)) {
			}
			else {
					String legal_moves = board.stringPosition(x+1, y+1);
					kingMoves.add(legal_moves);	
			}
			
			//move the piece diagonally right down
			if(board.outsideBoard(x-1, y+1) || board.checkOccupied(x-1, y+1) ) {
			}
			else {
					String legal_moves = board.stringPosition(x-1, y+1);
					kingMoves.add(legal_moves);	
			}
			
		}
		// moves for black king
		else {
			// to move the black king horizontally right
			if(board.checkOccupied(x, y+1) || board.outsideBoard(x, y+1)) {
			}
			else {
				String legal_moves = board.stringPosition(x, y+1);
				kingMoves.add(legal_moves);	
			}
			
			// to move the black king horizontally right
			if(board.checkOccupied(x, y-1) || board.outsideBoard(x, y-1)) {
			}
			else {
				String legal_moves = board.stringPosition(x, y-1);
				kingMoves.add(legal_moves);	
			}
			
			
			//move the piece vertically up
			if(board.checkOccupied(x-1, y) || board.outsideBoard(x-1, y)) {
			}
			else {
				String legal_moves = board.stringPosition(x-1, y);
				kingMoves.add(legal_moves);	
			}
			
			 // move the piece vertically down
			if(board.outsideBoard(x+1, y) || board.checkOccupied(x+1, y)) {
			}
			else {
				String legal_moves = board.stringPosition(x+1, y);
				kingMoves.add(legal_moves);	
			}
			
			
			//move the piece diagonally left up
			if(board.checkOccupied(x-1, y-1) || board.outsideBoard(x-1, y-1)) {
			}
			else {
				String legal_moves = board.stringPosition(x-1, y-1);
				kingMoves.add(legal_moves);	
			}
			
			//move the piece diagonally left down
			if(board.outsideBoard(x+1, y-1) || board.checkOccupied(x+1, y-1)) {
			}
			else {
				String legal_moves = board.stringPosition(x+1, y-1);
				kingMoves.add(legal_moves);	
			}
			
			//move the piece diagonally right up
			if(board.checkOccupied(x-1, y+1) || board.outsideBoard(x-1, y+1)) {
			}
			else {
					String legal_moves = board.stringPosition(x-1, y+1);
					kingMoves.add(legal_moves);	
			}
			
			//move the piece diagonally right down
			if(board.outsideBoard(x+1, y+1) || board.checkOccupied(x+1, y+1) ) {
			}
			else {
					String legal_moves = board.stringPosition(x+1, y+1);
					kingMoves.add(legal_moves);	
			}
			
		}
		
		return kingMoves;

     }
}
