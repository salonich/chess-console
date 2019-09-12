package a1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ChessBoardTest.class, BishopTest.class, KingTest.class, QueenTest.class, KnightTest.class, PawnTest.class, RookTest.class })

/*
 * Runs all the tests together
 */
public class ChessSuite {
	
	public static void main (String[] args){
		
		junit.textui.TestRunner.run(suite());
	}
	
	public static junit.framework.Test suite(){
		
		return new JUnit4TestAdapter (ChessSuite.class);
	}
}