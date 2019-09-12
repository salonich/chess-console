package a1;

import java.util.ArrayList;

public class Pawn extends ChessPiece{
	
	private static final String whitePawn = "\u2659";
	private static final String blackPawn = "\u265F";
	
    /*
     * Constructor to initialize ChessPiece with a board and Color
     */
	public Pawn(ChessBoard board, Color color) {
		super(board, color);
		
	}
	
	/*
	 * Returns the string of the unicode White Pawn and Black Pawn
	 */
	public String toString() {
		if(getColor() == Color.WHITE)
		   return whitePawn.toString();
		else if(getColor() == Color.BLACK)
			return blackPawn.toString();
		else 
			return null;
	}
	
	/*
	 *  Returns the legal moves of the Pawn from the given location
	 *  A pawn in the initial position may move one or two squares vertically forward to an empty square but cannot leap over any piece.
	 *  Subsequently it can move only one square vertically forward to an empty square. 
	 *  A pawn may also capture (replace) an opponent's piece diagonally one square in front of it. 
	 *  Pawns can never move backwards
	 */
    public ArrayList<String> legalMoves(){
		
		ArrayList<String> pawnMoves = new ArrayList<>();
		ArrayList<String> pawnFirstPositionWhite = new ArrayList<>();
		ArrayList<String> pawnFirstPositionBlack = new ArrayList<>();
		
		pawnFirstPositionWhite.add("a2");
		pawnFirstPositionWhite.add("b2");
		pawnFirstPositionWhite.add("c2");
		pawnFirstPositionWhite.add("d2");
		pawnFirstPositionWhite.add("e2");
		pawnFirstPositionWhite.add("f2");
		pawnFirstPositionWhite.add("g2");
		pawnFirstPositionWhite.add("h2");
		
		pawnFirstPositionBlack.add("a7");
		pawnFirstPositionBlack.add("b7");
		pawnFirstPositionBlack.add("c7");
		pawnFirstPositionBlack.add("d7");
		pawnFirstPositionBlack.add("e7");
		pawnFirstPositionBlack.add("f7");
		pawnFirstPositionBlack.add("g7");
		pawnFirstPositionBlack.add("h7");
		
		ChessPiece p = board.getChessPiece(this);
		int x = board.getX();
		int y = board.getY();
		
		// moves for white Pawn
		if(p.getColor() == Color.WHITE) {
			//to move one square vertically
			if(board.checkOccupied(x+1, y) || board.checkOccupied(x+1, y) ) {
				
			} else {
				String legal_moves = board.stringPosition(x+1, y);
				pawnMoves.add(legal_moves);					
			}
			
			
			
			//to let pawn move two squares when in initial position
			if(board.outsideBoard(x+2, y)) {
				
			} else if (board.checkOccupied(x+1, y) || board.checkOccupied(x+2, y)) {
				
			} else {
				
				if(p.getColor() == Color.WHITE && pawnFirstPositionWhite.contains(board.stringPosition(x, y))) {
					
					String legal_moves2 = board.stringPosition(x+2, y);
					pawnMoves.add(legal_moves2);				
				}
				
				else if (p.getColor() == Color.BLACK && pawnFirstPositionBlack.contains(board.stringPosition(x, y))) {
					String legal_moves2 = board.stringPosition(x+2, y);
					pawnMoves.add(legal_moves2);
				}
			}
			
			//to move the pawn diagonally left to kill another piece
			if(board.outsideBoard(x+1, y-1)) {
			}
			
			//check if the occupied piece is from the same team
			else if(board.checkOccupied(x+1, y-1)) {
				if(board.getChessPiece(p).getColor()== board.getChessPieceColor(x+1, y-1)) {
					
				}
				
				else {
					String legal_moves = board.stringPosition(x+1, y-1);
					pawnMoves.add(legal_moves);	
					
				}
			}
			
			//move the piece diagonally right
			if(board.outsideBoard(x+1, y+1)) {
			}
			
			//check if the occupied piece is from the same team
			else if(board.checkOccupied(x+1, y+1)) {
				if(board.getChessPiece(p).getColor()== board.getChessPieceColor(x+1, y+1)) {
					
				} else {
					String legal_moves = board.stringPosition(x+1, y+1);
					pawnMoves.add(legal_moves);	
					
				}
			}
		}
		// moves for black pawn
		else {
			//to move one square vertically
			if(board.checkOccupied(x-1, y) || board.checkOccupied(x-1, y) ) {
				
			} else {
				String legal_moves = board.stringPosition(x-1, y);
				pawnMoves.add(legal_moves);					
			}
			
			
			
			//to let pawn move two squares when in initial position
			if(board.outsideBoard(x-2, y)) {
				
			} else if (board.checkOccupied(x-1, y) || board.checkOccupied(x-2, y)) {
				
			} else {
				
				if(p.getColor() == Color.WHITE && pawnFirstPositionWhite.contains(board.stringPosition(x, y))) {
					
					String legal_moves2 = board.stringPosition(x-2, y);
					pawnMoves.add(legal_moves2);				
				}
				
				else if (p.getColor() == Color.BLACK && pawnFirstPositionBlack.contains(board.stringPosition(x, y))) {
					String legal_moves2 = board.stringPosition(x-2, y);
					pawnMoves.add(legal_moves2);
				}
			}
			
			//to move the pawn diagonally left to kill another piece
			if(board.outsideBoard(x-1, y-1)) {
			}
			
			//check if the occupied piece is from the same team
			else if(board.checkOccupied(x-1, y-1)) {
				if(board.getChessPiece(p).getColor()== board.getChessPieceColor(x-1, y-1)) {
					
				}
				
				else {
					String legal_moves = board.stringPosition(x-1, y-1);
					pawnMoves.add(legal_moves);	
					
				}
			}
			
			//move the piece diagonally right
			if(board.outsideBoard(x-1, y+1)) {
			}
			
			//check if the occupied piece is from the same team
			else if(board.checkOccupied(x-1, y+1)) {
				if(board.getChessPiece(p).getColor()== board.getChessPieceColor(x-1, y+1)) {
					
				} else {
					String legal_moves = board.stringPosition(x-1, y+1);
					pawnMoves.add(legal_moves);	
					
				}
			}	
		}
		
		return pawnMoves;
	}
	
}
