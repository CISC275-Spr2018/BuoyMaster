import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

class Model extends KeyAdapter{
	private int width, height, imageWidth, imageHeight;
	private int x=0;
	private int y=0;
	private int xDir = 1;
	private int yDir = 1;
	private int xIncr = 0;
	private int yIncr = 0;
	private boolean isMoving = true;
	private boolean isJumping = false;
	private OrcImage action = OrcImage.IDLE_S;
	private Direction orcDir = Direction.SOUTHEAST;
	private boolean isFire;
	
	int maxIncrement = 4;

	Model(int width, int height, int imageWidth, int imageHeight){
		this.width = width;
		this.height = height;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public OrcImage getAction() {
		return action;
	}
	public void setAction(OrcImage action) {
		this.action=action;
	}
	public int[] getDirect(){
		int[] dir = {this.xDir, this.yDir};
		return dir;
	}
	public boolean isMoving() {
		return isMoving;
	}
	public void toggleMoving() {
		this.isMoving = !this.isMoving;
	}
	public boolean isJumping() {
		return isJumping;
	}
	public void toggleJumping() {
		this.isJumping = !this.isJumping;
	}
	
	// Arvin : added numerous getters and setters
	public Direction getOrcDir() {
		return this.orcDir;
	}
	public boolean getIsMoving() {
		return this.isMoving;
	}
	public int getImageWidth(){
		return this.imageWidth;
	}
	public int getImageHeight() {
		return this.imageHeight;
	}
	public int getXDir() {
		return this.xDir;
	}
	public int getYDir() {
		return this.yDir;
	}
	public void setOrcDir(Direction d) {
		this.orcDir = d;
	}
	public void setXDir(int i) {
		this.xDir *= i;
	}
	public void setYDir(int i) {
		this.yDir *= i;
	}
	public void setX(int i) {
		this.x += i;
	}
	public void setY(int i) {
		this.y += i;
	}
	public int getXIncr() {
		return this.xIncr;
	}
	public int getYIncr() {
		return this.yIncr;
	}
	public void setXIncr(int i) {
		this.xIncr = i;
	}
	public void setYIncr(int i) {
		this.yIncr = i;
	}
	public boolean getIsJumping() {
		return this.isJumping;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public boolean getIsFire() {
		return isFire;
	}
	
	public int whatOverallIncrementXLeft() {
		if (this.xIncr < -5){
			return 0;
		}
		else {
			return maxIncrement;
		}
		
	}
	public int whatOverallIncrementXRight() {
		if (this.xIncr > 5){
			return 0;
		}
		else {
			return maxIncrement;
		}
		
	}
	public int whatOverallIncrementYDown() {
		if (this.yIncr > 7){
			return 0;
		}
		else {
			return maxIncrement;
		}
		
	}
	public int whatOverallIncrementYUp() {
		if (this.yIncr < -7){
			return 0;
		}
		else {
			return maxIncrement;
		}
		
	}
	
	//updates direction based on key pressed
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			xIncr -= whatOverallIncrementXLeft();
		}

		if (key == KeyEvent.VK_RIGHT) {
			xIncr += whatOverallIncrementXRight();
		}
		
		
		if (key == KeyEvent.VK_UP) {
			yIncr -= whatOverallIncrementYUp();
		}

		if (key == KeyEvent.VK_DOWN) {
			yIncr += whatOverallIncrementYDown();
		}
		
	}
	
	//In the future this can make the image stop moving when the keys are released
	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
		}
		if (key == KeyEvent.VK_RIGHT) {
		}
		if (key == KeyEvent.VK_UP) {
		}
		if (key == KeyEvent.VK_DOWN) {
		}
	}
	
	public void toggleFire() {
		this.isFire = !this.isFire;
	}
}