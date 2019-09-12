package a1;
import java.util.ArrayList;

public abstract class ChessPiece {
	
	public enum Color {WHITE, BLACK};
	protected ChessBoard board;
	protected int row ;
	protected int column;
	protected Color color;
	
	/* Initialize ChessPiece on the board it belongs
	 * ChessPiece needs to be assigned a Color- black or white
	 */
	public ChessPiece( ChessBoard board, Color color) {
		
			this.board = board;
			this.color = color;	
    }
	
	/*
	 * Returns Color of the current ChessPiece
	 */
	public Color getColor() {
		return this.color;
	}

	/*
	 * Returns the position of the current ChessPiece in the string format
	 * y axis = "a ..h"
	 * x axis = "1..8"
	 */
	public String getPosition() {
		
		this.row= board.getX();
		this.column = board.getY();	
		String position = board.stringPosition(this.row, this.column);	
		return position;
		
	}
	
	/*
	 * Accepts the position in String format
	 * Throws an exception if input position is incorrect
	 * Throws an exception if the move to the specified position is illegal for any reason
	 * Sets the position of the current ChessPiece to the given input position 
	 */
	public void setPosition(String position) throws IllegalPositionException{

		this.row= board.getX();
		this.column = board.getY();
		String initialPosition = board.stringPosition(this.row, this.column);
		int [] toPos = board.intPosition(position);
		
		if(board.outsideBoard(toPos[0], toPos[1])) {
			throw new IllegalPositionException("This is not a valid position");
		}
		
		try {
			board.move(initialPosition, position);
		}
		
		catch(IllegalMoveException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	abstract public String toString();
	abstract public ArrayList<String> legalMoves();
		
	
	
	
		
}
