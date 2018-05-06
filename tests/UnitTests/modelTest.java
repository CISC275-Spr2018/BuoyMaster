package UnitTests;
import junit.framework.TestCase;
import main.Buoy;
import main.Model;
import main.SpeedBoat;
import main.Vessel;
import main.Timer;

public class modelTest extends TestCase {
	Model target;
	
	protected void setUp() {
		target = new Model(0,0);
		target.setVessel(new SpeedBoat());
	}

	public void testModelConstructor() {
		assertNotNull("player was instantiated to null",target.getPlayer());
		assertNotNull("timer was created", target.getTimer());
		assertNotNull("gameMessage was created", target.getGameMessage());
		assertNotNull("buoy was created", target.getBuoy());
//		assertNotNull("sandBarCollection was created", target.get());
		assertNotNull("dock was created", target.getDock());
//		assertNotNull("shoreline was created", target.get());
		
	}

	public void testModelUpdate() {
		target.modelUpdate();
	}

	public void testGetPlayer() {
		assertTrue("player is of type vessel",target.getPlayer() instanceof Vessel);
	}

	public void testGetBuoy() {
		assertTrue("Buoy is of type Buoy",target.getBuoy() instanceof Buoy);
		
	}

	public void testGetTimer() {
		assertTrue("Timer is of type timer",target.getTimer() instanceof Timer);
	}

	public void testGetGameMessage() {
		assertTrue("GameMessage is of type GameMessage",target.getGameMessage() instanceof main.GameMessage);
	}

	public void testGetDock() {
		assertTrue("Dock is of type Dock",target.getDock() instanceof main.Dock);
	}

	public void testGetWidth() {
		assertEquals(target.getWidth(),0);
	}

	public void testGetHeight() {
		assertEquals(target.getHeight(),0);
	}

	public void testSetVessel() {
		target.setVessel(new SpeedBoat());
		assertTrue("speedBoat is a vessel",target.getPlayer() instanceof Vessel);
	}

}
