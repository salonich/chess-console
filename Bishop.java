package a1;
import java.util.ArrayList;

public class Bishop extends ChessPiece {
	
	private static final String whiteBishop = "\u2657";
	private static final String blackBishop = "\u265D";
	
	/*
	 * Constructor to initialize the piece with a board and Color
	 */
	public Bishop(ChessBoard board, Color color) {
		super(board, color);
	}
	
	/*
	 * Returns the string of the unicode White Bishop and Black Bishop
	 */
	public String toString() {
		if(getColor() == Color.WHITE)
		   return whiteBishop.toString();
		else if(getColor() == Color.BLACK)
			return blackBishop.toString();
		else
			return null;
	}
	
	/*
	 * Return an ArrayList with the legal moves of a Bishop from the current location
	 * Returns an empty ArrayList if no legal moves available.
	 * A bishop can move any number of squares diagonally in any direction as long as it does not have to leap over other pieces.
	 * At the end of the move, it can occupy a previously empty square or capture (replace) an opponent's piece but it cannot replace another piece of the same player.
	 */
    public ArrayList<String> legalMoves(){
		
		ArrayList<String> bishopMoves = new ArrayList<>();
		ChessPiece p = board.getChessPiece(this);
		int x = board.getX();
		int y = board.getY();
		
		diagonalDown(bishopMoves, p, x, y);
		
	    diagonalUp(bishopMoves, p, x, y);
			
		negativeDiagonalUp(bishopMoves, p, x, y);
			
		negativeDiagonalDown(bishopMoves, p, x, y);
				
		return bishopMoves;
	}
    
    /*
     * Returns legal moves for Bishop to move positive diagonal up
     */
	private void negativeDiagonalDown(ArrayList<String> bishopMoves, ChessPiece p, int x, int y) {
		for (int j = y+1, i = x-1 ; board.outsideBoard(i, j) == false ; j++, i--) {
			if(!board.checkOccupied(i, j)) {
				String position = board.stringPosition(i, j);
				bishopMoves.add(position);
			} else if(board.getChessPiece(p).getColor() != board.getChessPieceColor(i,j)) {
				String position = board.stringPosition(i, j);
				bishopMoves.add(position);
				break;
			} else
				break;
		}
	}
    
	/*
	 * Returns legal moves for Bishop to move positive diagonal down
	 */
	private void negativeDiagonalUp(ArrayList<String> bishopMoves, ChessPiece p, int x, int y) {
		for (int j = y-1, i = x-1 ; board.outsideBoard(i, j) == false ; j--, i--) {
			if(!board.checkOccupied(i, j)) {
				String position = board.stringPosition(i, j);
				bishopMoves.add(position);
			} else if(board.getChessPiece(p).getColor() != board.getChessPieceColor(i,j)) {
				String position = board.stringPosition(i, j);
				bishopMoves.add(position);
				break;
			} else
				break;
		}
	}

	/*
	 * Returns legal moves for Bishop to move negative diagonal up
	 */
	private void diagonalUp(ArrayList<String> bishopMoves, ChessPiece p, int x, int y) {
		for (int j = y-1, i = x+1 ; board.outsideBoard(i, j) == false ; j--, i++) {
			if(!board.checkOccupied(i, j)) {
				String position = board.stringPosition(i, j);
				bishopMoves.add(position);
			} else if(board.getChessPiece(p).getColor() != board.getChessPieceColor(i,j)) {
				String position = board.stringPosition(i, j);
				bishopMoves.add(position);
				break;
			} else
				break;
		}
	}
    
	/*
	 * Returns legal moves for Bishop to move negative diagonal down
	 */
	private void diagonalDown(ArrayList<String> bishopMoves, ChessPiece p, int x, int y) {
		for (int j = y+1, i = x+1 ; board.outsideBoard(i, j) == false ; j++, i++) {
			if(!board.checkOccupied(i, j)) {
				String position = board.stringPosition(i, j);
				bishopMoves.add(position);
			} else if(board.getChessPiece(p).getColor() != board.getChessPieceColor(i,j)) {
				String position = board.stringPosition(i, j);
				bishopMoves.add(position);
				break;
			} else
				break;
		}
	}
	
	
	

}
