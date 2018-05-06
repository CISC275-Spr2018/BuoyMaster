
public enum VesselType {
	JETSKI("jet_ski"),
	FISHINGBOAT("fishing_boat"),
	SPEEDBOAT("speed_boat");
	
	private String name = null;
	
	private VesselType(String s){
		name = s;
	}
	public String getName(){
		return name;
	}
}