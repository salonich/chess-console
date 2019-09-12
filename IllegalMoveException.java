package a1;

public class IllegalMoveException extends Exception{
	
	/**
	 * Exception thrown when the a ChessPiece is tried to move to the position
	 * it is not allowed to move to.
	 */
	private static final long serialVersionUID = 1L;

	public IllegalMoveException(String s) {
        super(s);
    }
}
