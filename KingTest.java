package a1;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class KingTest {
    
	/*
	 * This test verifies the Kings legal moves 
	 */
	@Test
	public void testLegalMoves() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    	
	    arrangeBoard(board);
    	
    	checkMovements(board);
    	
    	testLegalMovesException1();
    	
    	testLegalMovesException2();
    	
    	testLegalMovesException3();

    	
	    } catch (Exception e) {
	    	System.out.println("Exception Occurred");
	    }
	}

	private void checkMovements(ChessBoard board) throws IllegalPositionException, IllegalMoveException {
		// possible moves for king from this position are: f2, d2, e3, e1, d3, f3, f1
    	//The king can move vertically, horizontally and diagonally forward backward left and right by one step only.
    	ArrayList<String> kingMoves = new ArrayList<String>();
    	kingMoves.add("f2");
    	kingMoves.add("d2");
    	kingMoves.add("e3");
    	kingMoves.add("e1");
    	kingMoves.add("d3");
    	kingMoves.add("f3");
    	kingMoves.add("f1");
    	
    	assertEquals(board.getPiece("e2").legalMoves(), kingMoves);
    	ChessPiece p = board.getPiece("e2");
    	
    	//Checking if the king can move to those places
    	
    	board.move("e2", "f2");
    	assertTrue( p == board.getPiece("f2"));
    	board.move("f2", "e2"); 
    	
    	board.move("e2", "d2");
    	assertTrue( p == board.getPiece("d2"));
    	board.move("d2", "e2"); 
    	
    	board.move("e2", "e3");
    	assertTrue( p == board.getPiece("e3"));
    	board.move("e3", "e2");
    	
    	board.move("e2", "e1");
    	assertTrue( p == board.getPiece("e1"));
    	board.move("e1", "e2");
    	
    	board.move("e2", "d3");
    	assertTrue( p == board.getPiece("d3"));
    	board.move("d3", "e2");
    	
    	board.move("e2", "f3");
    	assertTrue( p == board.getPiece("f3"));
    	board.move("f3", "e2");
    	
    	board.move("e2", "f1");
    	assertTrue( p == board.getPiece("f1"));
    	board.move("f1", "e2");
	}

	private void arrangeBoard(ChessBoard board) throws IllegalMoveException {
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
    	
    	board.move("e1", "e2");
    	board.move("f1", "h3");
	}
	
	/*
	 * This test verifies if IllegalMoveException is thrown if a king moves on it's own team
	 */
	@Test
	public void testLegalMovesException1() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    try {
	    	
	    	//move over it's own member
	    	board.move("e1", "e2");
	    	board.move("e8", "e7");
	    
	    } catch (IllegalMoveException e) {
	    	return;
	    }
	    
	    fail("IllegalMoveException expected");
	}
	
	 /*
	  * To test if IllegalMoveException is thrown when king moves two steps ahead 
	  */
	@Test
	public void testLegalMovesException2() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		try {
		    	
		  //move after jumping over a piece 
		  board.move("e1", "e3");
		  board.move("e8", "e6");
		    	
		 } catch (IllegalMoveException e) {
		    return;
		 }
		    
		fail("IllegalMoveException expected");
   }
	
    /*
     * This test verifies that the king is unable to move steps horizontally, vertically or diagonally
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
		    	
		    board.move("e1", "e2");
		    board.move("e8", "e7");
		    board.move("f1", "h3");
		    	
		    //move two steps 
		    board.move("e2", "c2");
		    board.move("e7", "c5"); 	
		    	
		    } catch (IllegalMoveException e) {
		    	return;
		    }
		    fail("IllegalMoveException expected");
		}
}
