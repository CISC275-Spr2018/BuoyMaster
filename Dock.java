import javax.swing.JOptionPane;

public class Dock extends GamePiece{
	Dock(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
	}

	@Override
	public void onCollide() {
		JOptionPane.showMessageDialog(null, "You returned with the data!");
		System.exit(0);
	} 
}