package UnitTests;

import junit.framework.TestCase;
import main.FishingBoat;
import main.JetSki;
import main.SpeedBoat;
import main.Vessel;
import main.VesselType;

public class vesselTest extends TestCase {

	Vessel target;
	
	protected void setUp() throws Exception {
		super.setUp();
		target = new SpeedBoat();
	}

	public void testVessel() {
		assertNotNull(target.getMaxVel());
		assertNotNull(target.getRotationAngle());
		assertNotNull(target.getXLoc());
		assertNotNull(target.getYLoc());
		assertNotNull(target.getWakes());
	}

	public void testGetWakeStrength() {
		Vessel speedBoat = new SpeedBoat();
		Vessel jetSki = new JetSki();
		Vessel fishingBoat = new FishingBoat();
		assertTrue("speed boat wake strength higher than jet ski",speedBoat.getWakeStrength()>jetSki.getWakeStrength());
		assertTrue("jet ski wake strength higher than fishing boat",jetSki.getWakeStrength()>fishingBoat.getWakeStrength());
	}

	public void testUpdate() {
		target.setxVel(5);
		target.setyVel(0);
		target.update(1280,720);
		assertEquals("ship has moved to the right by five units",target.getXLoc(),5);
		target.setxVel(-10);
		target.update(1280, 720);
		target.update(1280, 720);
		//I think having to do TWO updates before negative velocity causes issues
//		System.out.println(target.getXLoc());
		assertEquals("Ship has hit left boundary and negated velocity",10.0,target.getXVel());
		target.setxVel(0);
		target.setyVel(10);
		target.update(1280, 300);
		target.update(1280, 300);
		target.update(1280, 300); //source of bugs at edge might be due to having to do an extra update before negating velocity
		assertEquals("Ship hit bottom boundary and negated y velocity",-10.0,target.getYVel());
	}

	public void testOutOfXBounds() {
		assertFalse("Not out of bounds",target.outOfXBounds(1000));
		assertTrue("Out of x bounds", target.outOfXBounds(-100));
	}

	public void testOutOfYBounds() {
		assertFalse("Not out of y bounds", target.outOfYBounds(1000));
		assertTrue("Out of Y bounds", target.outOfYBounds(-100));
	}

	public void testGetVesselType() {
		assertTrue("vessel type is speedboat",target.getVesselType().equals(VesselType.SPEEDBOAT));
	}

}
