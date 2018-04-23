
public class Buoy extends Model {
	int x=300;
	int y=600;
	Buoy(int width, int height, int imageWidth, int imageHeight) {
		super(width, height, imageWidth, imageHeight);
		// TODO Auto-generated constructor stub
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
}
