package a1;
import static org.junit.Assert.*;
import org.junit.Test;


public class KnightTest {
    /*
     * This test verifies that the Knight cannot move forward, diagonally left or right
     */
	@Test
	public void testLegalMoves() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    	
	    testLegalMovesException(board);
	    
	    testLegalMovesException2();
	    
	    testLegalMovesException3();
    	
    	
	    } catch (IllegalMoveException e) {
	    	return;
	    	
	    }
	    
	    fail("IllegalMoveException expected");
	    
	}
    
	/*
	 * This test verifies that the 1st White Knight cannot move forward, diagonally left or right
	 */
	private void testLegalMovesException(ChessBoard board) throws IllegalMoveException {
		board.move("e7", "e5");
    	board.move("f7", "f5");
    	board.move("d7", "d5");
    	board.move("c7", "c5");
    	board.move("b7", "b5");
    	board.move("a7", "a5");
    	
    	board.move("a2", "a4");
    	board.move("b2", "b4");
    	board.move("c2", "c4");
    	board.move("d2", "d4");
    	board.move("e2", "e4");
    	board.move("f2", "f4");
    	board.move("g2", "g4");
    	board.move("h2", "h4");
    	
    	// trying to move the white knight forward one step
    	board.move("b1", "b2");
    	board.move("b1", "c2");
    	board.move("b1", "a2");
	}
	
	/*
	 * This test verifies that the 2nd white Knight cannot move forward, diagonally left or right one step
	 */
	@Test
	public void testLegalMovesException2() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    
	    try {
	    board.move("e7", "e5");
    	board.move("f7", "f5");
    	board.move("d7", "d5");
    	board.move("c7", "c5");
    	board.move("b7", "b5");
    	board.move("a7", "a5");
    	
    	board.move("a2", "a4");
    	board.move("b2", "b4");
    	board.move("c2", "c4");
    	board.move("d2", "d4");
    	board.move("e2", "e4");
    	board.move("f2", "f4");
    	board.move("g2", "g4");
    	board.move("h2", "h4");
    	
    	//trying to move the knight diagonally left or right 
    	board.move("g1", "f2");
    	board.move("g1", "g2");
        board.move("g1", "h2");
    	
    	
	    } catch (Exception e) {
	       return;
	    }
	    
	    fail ("IllegalMoveException");
	    
	}
	
	/*
	 * This test verifies that the 1st black Knight cannot move forward, diagonally left or right one step
	 */
	@Test
	public void testLegalMovesException3() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    board.move("e7", "e5");
    	board.move("f7", "f5");
    	board.move("d7", "d5");
    	board.move("c7", "c5");
    	board.move("b7", "b5");
    	board.move("a7", "a5");
    	
    	board.move("a2", "a4");
    	board.move("b2", "b4");
    	board.move("c2", "c4");
    	board.move("d2", "d4");
    	board.move("e2", "e4");
    	board.move("f2", "f4");
    	board.move("g2", "g4");
    	board.move("h2", "h4");
    	
    	//trying to move the black knight forward diagonally right one step
        board.move("b8", "c7");
        board.move("b8", "a7");
    	board.move("b8", "b7");
    	
	    } catch (Exception e) {
	       return;
	    }
	    
	    fail ("IllegalMoveException");
	    
	}
	
	/*
	 * This test verifies 2nd black knight cannot move cannot move forward, diagonally left or right one step
	 */
	@Test
	public void testLegalMovesException4() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	   
	    
	    try {
	    board.move("e7", "e5");
    	board.move("f7", "f5");
    	board.move("d7", "d5");
    	board.move("c7", "c5");
    	board.move("b7", "b5");
    	board.move("a7", "a5");
    	
    	board.move("a2", "a4");
    	board.move("b2", "b4");
    	board.move("c2", "c4");
    	board.move("d2", "d4");
    	board.move("e2", "e4");
    	board.move("f2", "f4");
    	board.move("g2", "g4");
    	board.move("h2", "h4");
    	
    	////trying to move the black knight forward diagonally left one step
        board.move("g8", "f7");
    	board.move("g8", "g7");
    	board.move("g8", "h7");
    	
    	
	    } catch (Exception e) {
	       return;
	    }
	    
	    fail ("IllegalMoveException");
	    
	}
	
	@Test 
	public void testlegalMovesException5() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    try { 
	    	
	    ChessPiece p = board.getPiece("b1");
	    ChessPiece p1 = board.getPiece("g1");
	    ChessPiece p2 = board.getPiece("b8");
	    ChessPiece p3 = board.getPiece("g8");
	    
	    assertTrue(p.legalMoves().isEmpty());
	    assertTrue(p1.legalMoves().isEmpty());
	    assertTrue(p2.legalMoves().isEmpty());
	    assertTrue(p3.legalMoves().isEmpty());
    
	    } catch(IllegalPositionException e) {
	    	System.out.println("IllegalPositionExcpetion occurred");
	    }
    
	}

}
