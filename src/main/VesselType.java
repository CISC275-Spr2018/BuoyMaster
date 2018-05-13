package main;

import java.io.Serializable;

/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public enum VesselType implements Serializable{
	JETSKI("jet_ski"),
	FISHINGBOAT("fishing_boat"),
	SPEEDBOAT("speed_boat");
	
	private String name = null;
	/**@return returns the VesselType the user selected
	 * 
	 */
	private VesselType(String s){
		name = s;
	}
	/**@return returns the string key for the user's selection
	 * 
	 */
	public String getName(){
		return name;
	}
}