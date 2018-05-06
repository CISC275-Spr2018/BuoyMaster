/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class QuestionTrigger extends GamePiece{
	Model model;
	/*
	 * 
	 */
	QuestionTrigger(int x, int y, Model m){
		this.xLoc = x;
		//this.xVel = 3;
		this.yLoc = y;
		model = m;
	}
	/*
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
	}

}
