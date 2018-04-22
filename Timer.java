class Timer {
	int value;
	int increment;
	String message;
	
	Timer(){
		value = 100;
		increment = 1;
		message = "";
	}
	
	void update() {
		value -= increment;
		message = value + "";
	}
}