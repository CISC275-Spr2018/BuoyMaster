
public abstract class estuaryGamePiece {
	protected int Xloc;
	protected int Yloc;
	protected int xSize;
	protected int ySize;
	protected int imageWidth;
	protected int imageHeight;
	public estuaryGamePiece(int Xloc,int Yloc,int imageWidth, int imageHeight) {
		this.Xloc=Xloc;
		this.Yloc=Yloc;
		this.xSize=xSize;
		this.ySize=ySize;
		this.imageWidth=imageWidth;
		this.imageHeight=imageHeight;
	}
	public abstract void onCollide();
	public abstract boolean hasCollide(); 
	public abstract void create();
	public abstract void update();
	public abstract void destroy();
}
