package a1;
import static org.junit.Assert.*;
import org.junit.Test;

public class QueenTest {

	/*
	 * This test verifies the Queen cannot move as it has no legal moves
	 */
	
	@Test 
	public void testlegalMoves() {
		
		testLegalMovesException1();
		
		testLegalMovesException2();
		
		testLegalMovesException3();
		
    
	}

	private void testLegalMovesException1() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    try { 
	    	
	    ChessPiece p = board.getPiece("d1");
	    ChessPiece p1 = board.getPiece("d8");  
	    assertTrue(p.legalMoves().isEmpty());
	    assertTrue(p1.legalMoves().isEmpty());
	    
	    } catch(IllegalPositionException e) {
	    	System.out.println("Excpetion occurred");
	    }
	}
	
	   /*
	    * This test verifies the White Queen cannot move forward, diagonally left or right one step
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
	    	
	    	// trying to move the white queen forward, diagonally right and left one step
	        board.move("d1", "d2");
	    	board.move("d1", "c2");
	    	board.move("d1", "e2");
	    
		    } catch (IllegalMoveException e) {
		    	
		    	return;
		    }
		    
		    fail("IllegalMoveException Expected");
		    
		}
		
		/*
		 * This test verifies the Black Queen cannot move forward, diagonally left or right as it has no legal moves
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
	 
	    	//trying to move the black queen forward diagonally right and left one step
	        board.move("d8", "c7");
	    	board.move("d8", "e7");
	    	board.move("d8", "d7");
	    	
	    	
		    } catch (Exception e) {	
		    	return;
		    }
		    
		    fail("IllegalMoveException expected");
		    
		}

}
