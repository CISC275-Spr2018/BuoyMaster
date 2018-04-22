
public class textBubble extends estuaryGamePiece{
	private String text;
	public textBubble(String text, int Xloc, int Yloc, int imageWidth, int imageHeight) {
		super(Xloc, Yloc,imageWidth, imageHeight);
		this.text=text;
	}
	public void open() {}
	public void displayInfo() {}
	public void close() {}
	@Override
	public boolean hasCollide() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
		
	}
}
