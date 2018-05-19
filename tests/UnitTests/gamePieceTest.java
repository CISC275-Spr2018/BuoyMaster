package UnitTests;

import junit.framework.TestCase;
import main.GamePiece;
import main.SandBar;
import main.SpeedBoat;

public class gamePieceTest extends TestCase {
	
	GamePiece target;

	protected void setUp() throws Exception {
		super.setUp();
		target = new SpeedBoat();
	}

	public void testHasCollided() {
		GamePiece sandBarCollide = new SandBar(0, 300, null, null);
		System.out.println(target.getXLoc()+","+target.getYLoc());
		GamePiece sandBarMiss = new SandBar(200,200, null, null);
		
		assertTrue("collide should collide at 0,0", target.hasCollided(sandBarCollide));
		assertFalse("miss should NOT collid 0,0 vs 200,200",target.hasCollided(sandBarMiss));
		
	}

	public void testWithinXRange() {
		GamePiece sandBarCollide = new SandBar(10,0,null,null);//should be within X range
		GamePiece sandBarMiss = new SandBar(300,0,null,null);//should be OUT of X range
		
		assertTrue("collid is within x range (10 is within range of vessel @ x=0)",
				target.withinXRange(sandBarCollide));
		assertFalse("miss is NOT within x range (300 is outside of vessel @ x=0",
				target.withinXRange(sandBarMiss));
	}

	public void testWithinYRange() {
		GamePiece sandBarCollide = new SandBar(0,310,null,null);
		GamePiece sandBarMiss = new SandBar(0,0,null,null);
		
		assertTrue("Colide is within y range of vessel (310 is within range of vessel @ y=300",
				target.withinYRange(sandBarCollide));
		assertFalse("Miss is NOT within y range of vessel (0 is outside of range of vessel @ y=300",
				target.withinYRange(sandBarMiss));
	}

}
