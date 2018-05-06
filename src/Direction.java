/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public enum Direction {

	NORTH("north"),
	NORTHEAST("northeast"),
	EAST("east"),
	SOUTHEAST("southeast"),
	SOUTH("south"),
	SOUTHWEST("southwest"),
	WEST("west"),
	NORTHWEST("northwest");

	private String name = null;
	/*Sets the direction to the input string
	 * @param s the direction
	 */
	private Direction(String s){
		name = s;
	}
	/*@return returns the given direction
	 * 
	 */
	public String getName() {
		return name;
	}
}
