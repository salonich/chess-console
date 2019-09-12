package a1;

public class IllegalPositionException extends Exception {
	
	/**
	 * Exception thrown if the position requested or of the ChessPiece
	 * is outside the board
	 */
	private static final long serialVersionUID = 1L;

	public IllegalPositionException(String s) {
        super(s);
    }
     
}
