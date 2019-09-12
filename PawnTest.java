package a1;
import static org.junit.Assert.*;
import org.junit.Test;

public class PawnTest {
    
	/*
	 * This test verifies that Pawn has correct legal moves 
	 * and if it can move to those places
	 */
	@Test
	public void testLegalMoves() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    
	    try {
	    	
	    whitePawn2steps(board);
	    
  
	    blackPawn2Steps(board);
	    
	    IllegalMoveException1();
	    
	    IllegalMoveException2();
	    
	    IllegalMoveException3();
	    
	    IllegalMoveException4();
  
	    } catch (IllegalMoveException e) {
	    	System.out.println("IllegalMoveException Occurred");
	    	
	    }
	    
	    catch (IllegalPositionException e) {
	    	System.out.println("IllegalPositionException occurred");
	    }    
	    
	}

	private void blackPawn2Steps(ChessBoard board) throws IllegalPositionException, IllegalMoveException {
		//To verify if the first black pawns can move two steps.
	    ChessPiece p8 = board.getPiece("a7");
	    board.move("a7", "a5");
	    assertTrue(board.getPiece("a5").toString().equals(p8.toString()));
	    
	    ChessPiece p9 = board.getPiece("b7");
	    board.move("b7", "b5");
	    assertTrue(board.getPiece("b5").toString().equals(p9.toString()));
	    
	    ChessPiece p10 = board.getPiece("c7");
	    board.move("c7", "c5");
	    assertTrue(board.getPiece("c5").toString().equals(p10.toString()));
	    
	    ChessPiece p11 = board.getPiece("d7");
	    board.move("d7", "d5");
	    assertTrue(board.getPiece("d5").toString().equals(p11.toString()));
	    
	    ChessPiece p12 = board.getPiece("e7");
	    board.move("e7", "e5");
	    assertTrue(board.getPiece("e5").toString().equals(p12.toString()));
	    
	    ChessPiece p13 = board.getPiece("f7");
	    board.move("f7", "f5");
	    assertTrue(board.getPiece("f5").toString().equals(p13.toString()));
	    
	    ChessPiece p14 = board.getPiece("g7");
	    board.move("g7", "g5");
	    assertTrue(board.getPiece("g5").toString().equals(p14.toString()));
	    
	    ChessPiece p15 = board.getPiece("h7");
	    board.move("h7", "h5");
	    assertTrue(board.getPiece("h5").toString().equals(p15.toString()));
	}

	private void whitePawn2steps(ChessBoard board) throws IllegalPositionException, IllegalMoveException {
		//To verify if the first white pawns can move two steps. 
	    ChessPiece p = board.getPiece("a2");
	    board.move("a2", "a4");
	    assertTrue(board.getPiece("a4").toString().equals(p.toString()));
	    
	    ChessPiece p1 = board.getPiece("b2");
	    board.move("b2", "b4");
	    assertTrue(board.getPiece("b4").toString().equals(p1.toString()));
	    
	    ChessPiece p2 = board.getPiece("c2");
	    board.move("c2", "c4");
	    assertTrue(board.getPiece("c4").toString().equals(p2.toString()));
	    
	    ChessPiece p3 = board.getPiece("d2");
	    board.move("d2", "d4");
	    assertTrue(board.getPiece("d4").toString().equals(p3.toString()));
	    
	    ChessPiece p4 = board.getPiece("e2");
	    board.move("e2", "e4");
	    assertTrue(board.getPiece("e4").toString().equals(p4.toString()));
	    
	    ChessPiece p5 = board.getPiece("f2");
	    board.move("f2", "f4");
	    assertTrue(board.getPiece("f4").toString().equals(p5.toString()));
	    
	    ChessPiece p6 = board.getPiece("g2");
	    board.move("g2", "g4");
	    assertTrue(board.getPiece("g4").toString().equals(p6.toString()));
	    
	    ChessPiece p7 = board.getPiece("h2");
	    board.move("h2", "h4");
	    assertTrue(board.getPiece("h4").toString().equals(p7.toString()));
	}
	
	/*
	 * This test verifies pawn cannot move three steps at first move
	 */
	@Test
	public void IllegalMoveException1() {
		ChessBoard board = new ChessBoard();
	    board.initialize();
	    try {
	    	board.move("a2", "a5");
	    	board.move("a7", "a4");
	    } catch (IllegalMoveException e) {
	    	return;
	    }
	    
	    fail("IllegalMoveException expected");
	}
	
	/*
	 * This test verifies pawn cannot move diagonally until it's capturing a piece from another team
	 */
	@Test
	public void IllegalMoveException2() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		try {
		   board.move("a2", "b3"); 	
		} catch (IllegalMoveException e) {
		     return;
		}
		    
		 fail("IllegalMoveException expected");
		}
		
    /*
     * This test verifies pawn cannot move backwards
     */
	@Test
	public void IllegalMoveException3() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		try {
			board.move("a2", "a4");
			board.move("a4", "a3");
			 
	    } catch (IllegalMoveException e) {
		      return;
	    }
				    
	     fail("IllegalMoveException expected");
	}
	
	/*
	 * This test verifies pawn cannot move two steps after the first move
	 */
	@Test
	public void IllegalMoveException4() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		try {
			board.move("a2", "a4");
			board.move("a4", "a6");
				 
		 } catch (IllegalMoveException e) {
			   return;
		 }
					    
		     fail("IllegalMoveException expected");
		}
	
	

}
