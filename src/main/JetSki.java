package main;

public class JetSki extends Vessel{
	JetSki(){
		super();
		type = VesselType.JETSKI;
		maxVel = 10;
		this.updatesBetweenWakes = 2;
	}
}
