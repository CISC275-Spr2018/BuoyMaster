package UnitTests;
import junit.framework.TestCase;
import main.Arrow;
import main.Buoy;
import main.Model;
import main.SpeedBoat;
import main.Vessel;
import main.Timer;

public class modelTest extends TestCase {
	Model target;
	
	protected void setUp() {
		target = new Model(1280,720,false);
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
		//some of the logic for the model update && tutorial switching
		target.setTutorial(true);
		target.modelUpdate();
		target.setTutorialSandbar(true);
		target.getPlayer().setxVel(15);
		target.getBuoy().sandBar = true;
		target.modelUpdate();
		assertEquals("vessel is at 15",target.getPlayer().getXLoc(),15);
		target.setTutorial(false);
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
		assertEquals(target.getWidth(),1280);
	}

	public void testGetHeight() {
		assertEquals(target.getHeight(),720);
	}

	public void testSetVessel() {
		target.setVessel(new SpeedBoat());
		assertTrue("speedBoat is a vessel",target.getPlayer() instanceof Vessel);
	}
	
	public void testAddTime() {
		assertFalse("add time, buoy not correct",target.addTime());
		target.getBuoy().correct = true;
		assertTrue("add time, buoy correct",target.addTime());
	}
	
	public void testGetArrow() {
		assertTrue("get arrow returns Arrow object",target.getArrow() instanceof Arrow);
	}
	
	public void testRandomNum() {
		int rand = Model.randomNum(0,10);
		assertTrue("rand works", (rand<=10) && (rand>=0));
	}

}
