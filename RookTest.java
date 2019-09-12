package a1;
import static org.junit.Assert.*;
import org.junit.Test;

 public class RookTest {

	@Test
	public void testLegalMoves() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    	
		    ChessPiece p = board.getPiece("a1");
		    ChessPiece p1 = board.getPiece("h1");
		    ChessPiece p2 = board.getPiece("a8");
		    ChessPiece p3 = board.getPiece("h8");
		    arrangeBoard(board);
		    
		    firstWhiteRook(board, p);
		    
		    secondWhiteRook(board, p1);  
		    
		    firstBlackRook(board, p2);
		    
		    secondBlackRook(board, p3);
		   
		    
	    } catch (IllegalMoveException e) {
	    	System.out.println(e.getMessage());
	    	
	    } catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		
	}

	private void secondBlackRook(ChessBoard board, ChessPiece p3)
			throws IllegalMoveException, IllegalPositionException {
		//move 2nd black rook
		board.move("h7", "h6");
		assertTrue(board.getPiece("h6").toString().equals(p3.toString()));
		board.move("h6", "h7");
		
		board.move("h7", "c7");
		assertTrue(board.getPiece("c7").toString().equals(p3.toString()));
		board.move("c7", "h7");
	}

	private void firstBlackRook(ChessBoard board, ChessPiece p2) throws IllegalMoveException, IllegalPositionException {
		//move 1st black rook 
		board.move("a7", "a5");
		assertTrue(board.getPiece("a5").toString().equals(p2.toString()));
		board.move("a5", "a7");
		
		board.move("a7", "g7");
		assertTrue(board.getPiece("g7").toString().equals(p2.toString()));
		board.move("g7", "a7");
	}

	private void secondWhiteRook(ChessBoard board, ChessPiece p1)
			throws IllegalMoveException, IllegalPositionException {
		//move 2nd white rook
		board.move("h2", "h4");
		assertTrue(board.getPiece("h4").toString().equals(p1.toString()));
		board.move("h4", "h2");
		
		board.move("h2", "c2");
		assertTrue(board.getPiece("c2").toString().equals(p1.toString()));
		board.move("c2", "h2");
	}

	private void firstWhiteRook(ChessBoard board, ChessPiece p) throws IllegalMoveException, IllegalPositionException {
		//move 1st white rook
		board.move("a2", "a4");
		assertTrue(board.getPiece("a4").toString().equals(p.toString()));
		board.move("a4", "a2");
		
		board.move("a2", "g2");
		assertTrue(board.getPiece("g2").toString().equals(p.toString()));
		board.move("g2", "a2");
	}
	
	/*
	 * Arranges the board by moving white and black pawns to clear the way to test Bishop
	 * Kills the pawns to clear the board.
	 */
	protected void arrangeBoard(ChessBoard board) throws IllegalMoveException {
		//Move the white Pawns to test rook Movements
		board.move("a2", "a4");
		board.move("b2", "b4");
		board.move("c2", "c4");
		board.move("d2", "d4");
		board.move("e2", "e4");
		board.move("f2", "f4");
		board.move("g2", "g4");
		board.move("h2", "h4");
		
		//Move the black pawns to test rook movements
		board.move("h7", "h5");
		board.move("g7", "g5");
		board.move("f7", "f5");
		board.move("e7", "e5");
		board.move("d7", "d5");
		board.move("c7", "c5");
		board.move("b7", "b5");
		board.move("a7", "a5");
		
		//kill the pawns
		board.move("a5", "b4");
		board.move("b5", "c4");
		board.move("c5", "d4");
		board.move("d5", "e4");
		board.move("e5", "f4");
		board.move("f5", "g4");
		board.move("g5", "h4");
		board.move("a4", "a5");
		
		//move the white Rook to make movements horizontally and vertically
		 board.move("a1", "a2");
		 board.move("h1", "h2");
		 
		//move the black Rook to make movements horizontally and vertically
		 board.move("a8", "a7");
		 board.move("h8", "h7");
		 
		 
	}
	
	@Test
	public void firstWRookException() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {

	     arrangeBoard(board);
	     
	     board.move("a2", "b3");
	     
	    } catch (IllegalMoveException e) {
	    	return;
	    	
	    } 
	    
	    fail("IllegalMoveException expected");
	}
	
	@Test
	public void secondWRookException() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {

	     arrangeBoard(board);
	     
	     board.move("h2", "g3");
	     
	    } catch (IllegalMoveException e) {
	    	return;
	    	
	    } 
	    
	    fail("IllegalMoveException expected");
	}
	
	@Test
	public void firstBRookException() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {

	     arrangeBoard(board);
	     
	     board.move("a7", "c3");
	     
	    } catch (IllegalMoveException e) {
	    	return;
	    	
	    } 
	    
	    fail("IllegalMoveException expected");
	}
	
	@Test
	public void secondBRookException() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {

	     arrangeBoard(board);
	     
	     board.move("h7", "f5");
	     
	    } catch (IllegalMoveException e) {
	    	return;
	    	
	    } 
	    
	    fail("IllegalMoveException expected");
	}
	
	
	
	

}
