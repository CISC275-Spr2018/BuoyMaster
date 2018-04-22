
public abstract class Vessel extends estuaryGamePiece{
	private int speed;
	private int turning;
	private int wakeHeight;
	private int xDir;
	private int yDir;
	private boolean inverted;
	private int yIncr;
	public Vessel(int Xloc, int Yloc, int imageWidth, int imageHeight) {
		super(Xloc, Yloc, imageWidth, imageHeight);
	}
	public int getX(){
		return this.Xloc;
	}
	public int getY(){
		return this.Yloc;
	}
	public int[] getDirect(){
		int[] dir = {this.xDir, this.yDir};
		return dir;
	}
	public int getXDir() {
		// TODO Auto-generated method stub
		return this.Xloc;
	}
	public void setxDir(int x){
		this.xDir=x;			
	}
	public boolean getInverted(){
		return this.inverted;
	}
	public void setInverted(boolean inverted){
		this.inverted=inverted;
	}
	public int getYDir(){
		return this.yDir;
	}
	public void setYDir(int y){
		this.yDir=y;
	}
	public int getImageWidth(){
		return this.imageWidth;
	}
	public int getImageHeight() {
		return this.imageHeight;
	}
	public void goForward() {
		this.yIncr=speed;
	}
	public BoatImage getAction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
