class Timer {
	int value;
	int increment;
	
	Timer(){
		value = 100;
		increment = 1;
	}
	
	void update() {
		value -= increment;
	}
}