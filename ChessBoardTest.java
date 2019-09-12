package a1;
import static org.junit.Assert.*;
import org.junit.Test;

import a1.ChessPiece.Color;

public class ChessBoardTest {

	/*
	 * This test checks if all the pieces are at the correct initial position 
	 */
	@Test
	public void testInitialize() {
		
		ChessBoard board = new ChessBoard();
		board.initialize();
		
		try {
			
			assertTrue(board.getPiece("a1").toString().equals("\u2656"));
	        assertTrue(board.getPiece("b1").toString().equals("\u2658"));
	        assertTrue(board.getPiece("c1").toString().equals("\u2657"));
	        assertTrue(board.getPiece("d1").toString().equals("\u2655"));
	        assertTrue(board.getPiece("e1").toString().equals("\u2654"));
	        assertTrue(board.getPiece("f1").toString().equals("\u2657"));
	        assertTrue(board.getPiece("g1").toString().equals("\u2658"));
	        assertTrue(board.getPiece("h1").toString().equals("\u2656"));
	        assertTrue(board.getPiece("a2").toString().equals("\u2659"));
	        assertTrue(board.getPiece("b2").toString().equals("\u2659"));
	        assertTrue(board.getPiece("c2").toString().equals("\u2659"));
	        assertTrue(board.getPiece("d2").toString().equals("\u2659"));
	        assertTrue(board.getPiece("e2").toString().equals("\u2659"));
	        assertTrue(board.getPiece("f2").toString().equals("\u2659"));
	        assertTrue(board.getPiece("g2").toString().equals("\u2659"));
	        assertTrue(board.getPiece("h2").toString().equals("\u2659"));
	        assertTrue(board.getPiece("a7").toString().equals("\u265F"));
	        assertTrue(board.getPiece("b7").toString().equals("\u265F"));
	        assertTrue(board.getPiece("c7").toString().equals("\u265F"));
	        assertTrue(board.getPiece("d7").toString().equals("\u265F"));
	        assertTrue(board.getPiece("e7").toString().equals("\u265F"));
	        assertTrue(board.getPiece("f7").toString().equals("\u265F"));
	        assertTrue(board.getPiece("g7").toString().equals("\u265F"));
	        assertTrue(board.getPiece("h7").toString().equals("\u265F"));
	        assertTrue(board.getPiece("a8").toString().equals("\u265C"));
	        assertTrue(board.getPiece("b8").toString().equals("\u265E"));
	        assertTrue(board.getPiece("c8").toString().equals("\u265D"));
	        assertTrue(board.getPiece("d8").toString().equals("\u265B"));
	        assertTrue(board.getPiece("e8").toString().equals("\u265A"));
	        assertTrue(board.getPiece("f8").toString().equals("\u265D"));
	        assertTrue(board.getPiece("g8").toString().equals("\u265E"));
	        assertTrue(board.getPiece("h8").toString().equals("\u265C"));
        
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
    /*
     * This test verifies if getPiece method gets the correct piece, if given a valid position
     */
	@Test
	public void testGetPiece() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		
		
		//verifies if getPiece returns the correct Piece
		try {
			
		ChessPiece rookWhite = new Rook(board, Color.WHITE);
		assertEquals(board.getPiece("a1").toString(), rookWhite.toString());
		assertEquals(board.getPiece("h1").toString(), rookWhite.toString());	
		}
		
		catch(Exception e) {
			System.out.println("Exception caught");
		}
		
	}

	/*
	 *  Verify if placePiece places the correct piece at the correct position, if only
	 *  the ChessPiece and position are valid
	 */
	@Test
	public void testPlacePiece() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		
		
		try {
			//moving the piece using placePiece
			ChessPiece p = board.getPiece("a7");
			board.placePiece(p, "a5");	
			//Verifying if the same piece is moved to a new location
			assertTrue(board.getPiece("a5").toString().equals(p.toString()));
			testPlacePieceException();
			
		} catch(Exception e) {
			System.out.println("Exception caught");
		}
	
	}
	
	/*
	 * This test verifies if placePiece throws an exception if a piece is being moved to an illegal position
	 */
	@Test
	public void testPlacePieceException() {
		ChessBoard board = new ChessBoard();
		board.initialize();	
		try {
			board.move("a7", "a5");
			//Checking if place piece does not allow illegal Moves.
	        board.move("a5", "a3");
			board.move("a5", "a9");	
			
		} catch(Exception e) {
		    return;
		}
		
		fail("IllegalMoveException expected");
	}
	

	//verify if it can move a piece from given location to another location
	@Test
	public void testMove() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		try {
			//saving the piece to be moved in other variable
			ChessPiece p = board.getPiece("a2");
			
			//moving the piece
			board.move("a2", "a4");
			
			//checking if the same piece is present at the new loaction
			assertEquals(p, board.getPiece("a4"));
			
			testMoveException();
			
		 } catch( Exception e) {
			System.out.println("Exception occurred");
	   }
	}
	
	@Test
	public void testMoveException() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		try {
			board.move("a2", "a5");
		} catch (IllegalMoveException e) {
			// TODO Auto-generated catch block
			return;
		}
		fail("IllegalMoveException expected");
	}
	
	

}
