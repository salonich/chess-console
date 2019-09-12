package a1;
import static org.junit.Assert.*;
import org.junit.Test;

public class BishopTest {
    /*
     * Tests if Bishop can moves to all the legal moves 
     */
	@Test
	public void testLegalMoves() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    	arrangeBoard(board);
	    	
	    	
	    	ChessPiece p1 = board.getPiece("c1");
	    	ChessPiece p2 = board.getPiece("f1");
	    	ChessPiece p3 = board.getPiece("c8");
	    	ChessPiece p4 = board.getPiece("f8");
	    	
	    	firstWhiteBishop(board, p1);
	      	
	    	secondWhiteBishop(board, p2);
	   
	    	firstBlackBishop(board, p3);
	     
	    	secondBlackBishop(board, p4);
	    	
	    	testLegalMovesException1();
	    	
	    	testLegalMovesException2();
	    	
	    	testLegalMovesException3();
	    	
	    } catch(Exception e) {
	    	System.out.println("Exception Occurred");
	    }
	}
	
	/*
	 * Tests if 2nd black bishop moves correctly
	 * Possible moves for 2nd black bishop are : e7, d6, c5, g7, h6
	 */

	private void secondBlackBishop(ChessBoard board, ChessPiece p4)
			throws IllegalMoveException, IllegalPositionException {
		board.move("f8", "e7");
		assertTrue( p4 == board.getPiece("e7"));
		board.move("e7", "f8");
		
		board.move("f8", "d6");
		assertTrue( p4 == board.getPiece("d6"));
		board.move("d6", "f8");
		
		board.move("f8", "c5");
		assertTrue( p4 == board.getPiece("c5"));
		board.move("c5", "f8");
		
		board.move("f8", "g7");
		assertTrue( p4 == board.getPiece("g7"));
		board.move("g7", "f8");
		
		board.move("f8", "h6");
		assertTrue( p4 == board.getPiece("h6"));
		board.move("h6", "f8");
	}
    
	/*
	 * Tests if 1st black bishop moves correctly
	 * Possible moves for 1st black bishop are : b7, a6, d7, e6, f5
	 */
	private void firstBlackBishop(ChessBoard board, ChessPiece p3)
			throws IllegalMoveException, IllegalPositionException {
		board.move("c8", "b7");
		assertTrue( p3 == board.getPiece("b7"));
		board.move("b7", "c8");
		
		board.move("c8", "a6");
		assertTrue( p3 == board.getPiece("a6"));
		board.move("a6", "c8");
		
		board.move("c8", "d7");
		assertTrue( p3 == board.getPiece("d7"));
		board.move("d7", "c8");
		
		board.move("c8", "e6");
		assertTrue( p3 == board.getPiece("e6"));
		board.move("e6", "c8");
		
		board.move("c8", "f5");
		assertTrue( p3 == board.getPiece("f5"));
		board.move("f5", "c8");
	}
    
	/*
	 * Tests if 2nd white bishop moves correctly
	 * Possible moves for 2nd white bishop are : g2, h3, e2, d3, c4
	 */
	private void secondWhiteBishop(ChessBoard board, ChessPiece p2)
			throws IllegalMoveException, IllegalPositionException {
		board.move("f1", "g2");
		assertTrue( p2 == board.getPiece("g2"));
		board.move("g2", "f1");
		
		board.move("f1", "h3");
		assertTrue( p2 == board.getPiece("h3"));
		board.move("h3", "f1");
		
		board.move("f1", "e2");
		assertTrue( p2 == board.getPiece("e2"));
		board.move("e2", "f1");
		
		board.move("f1", "d3");
		assertTrue( p2 == board.getPiece("d3"));
		board.move("d3", "f1");
		
		board.move("f1", "c4");
		assertTrue( p2 == board.getPiece("c4"));
		board.move("c4", "f1");
	}
   
	/*
	 * Tests if 1st white bishop moves correctly
	 * Possible moves for 1st white bishop are : d2, e3, f4, b2, a3
	 */
	private void firstWhiteBishop(ChessBoard board, ChessPiece p1)
			throws IllegalMoveException, IllegalPositionException {
		board.move("c1", "d2");
		assertTrue( p1 == board.getPiece("d2"));
		board.move("d2", "c1");
		
		board.move("c1", "e3");
		assertTrue( p1 == board.getPiece("e3"));
		board.move("e3", "c1");
		
		board.move("c1", "f4");
		assertTrue( p1 == board.getPiece("f4"));
		board.move("f4", "c1");
		
		board.move("c1", "b2");
		assertTrue( p1 == board.getPiece("b2"));
		board.move("b2", "c1");
		
		board.move("c1", "a3");
		assertTrue( p1 == board.getPiece("a3"));
		board.move("a3", "c1");
	}
 
	/*
	 * Arranges the board by moving white and black pawns to clear the way to test Bishop
	 * Kills the pawns to clear the board.
	 */
	private void arrangeBoard(ChessBoard board) throws IllegalMoveException {
		arrangeBoard2(board);
		
		//kill the pawns
		board.move("a5", "b4");
		board.move("b5", "c4");
		board.move("c5", "d4");
		board.move("d5", "e4");
		board.move("e5", "f4");
		board.move("f5", "g4");
		board.move("g5", "h4");
		board.move("a4", "a5");
	}
	
	/*
	 * Verifies the bishop doesn't move on it's own team members
	 */
	@Test
	public void testLegalMovesException1() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    	
	    	//CHeck if bishop does not move on it's own team 
	    	board.move("c1", "c2");
	    	board.move("f1", "f2");
	    	board.move("c8", "c7");
	    	board.move("f8", "f7");
	    	
	    } catch(IllegalMoveException e) {
	    	return;
	    	
	    }
	    fail("IllegalMoveException expected");
	    
	    }
	
	/*
	 * This test verifies that Bishop does not move horizontally left or right
	 */
	@Test
	public void testLegalMovesException2() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    	
	    	arrangeBoard2(board); 
	    	
	    	//move the bishop where they can move horizontally left and right
	    	board.move("c1", "d2");
	    	board.move("f1", "g2");
	    	board.move("c8", "b7");
	    	board.move("f8", "e7");
	    	
	    	//Verify that bishop does not move horizontally left and right
	        board.move("d2", "b2");
	    	board.move("d2", "c2");
	    	board.move("g2", "h2");
	    	board.move("g2", "f2");
	    	board.move("b7", "c7");
	    	board.move("b7", "a7");
	    	board.move("e7", "d7");
	    	board.move("e7", "f7");
	    	
	    } catch(IllegalMoveException e) {
	    	return;
	    	
	    }
	    fail("IllegalMoveException expected");
	    
	    }

	private void arrangeBoard2(ChessBoard board) throws IllegalMoveException {
		// move the black pawns
		board.move("h7", "h5");
		board.move("g7", "g5");
		board.move("f7", "f5");
		board.move("e7", "e5");
		board.move("d7", "d5");
		board.move("c7", "c5");
		board.move("b7", "b5");
		board.move("a7", "a5");
		
		//move the white pawns
		board.move("a2", "a4");
		board.move("b2", "b4");
		board.move("c2", "c4");
		board.move("d2", "d4");
		board.move("e2", "e4");
		board.move("f2", "f4");
		board.move("g2", "g4");
		board.move("h2", "h4");
	}
	/*
	 * This test verifies that the bishop does not move vertically left or right
	 */
	@Test
	public void testLegalMovesException3() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    	
	    	arrangeBoard2(board); 
	    	
	    	//move the bishop where they can move horizontally left and right
	    	board.move("c1", "d2");
	    	board.move("f1", "g2");
	    	board.move("c8", "b7");
	    	board.move("f8", "e7");
	   
	    	//Verify that bishop does not move vertically
	    	board.move("d2", "d3");
	    	board.move("g2", "g3");
	    	board.move("b7", "b6");
	    	board.move("e7", "e6");
	    
	    	
	    	
	    } catch(IllegalMoveException e) {
	    	return;
	    	
	    }
	    fail("IllegalMoveException expected");
	    
	    }


}
