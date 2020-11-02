/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

/*
 * This class will represents any drawable item on the screen.
 */
public abstract class GameElement {

	// -------------------------------------
	// Attributes
	// -------------------------------------
	protected int posX;
	protected int posY;
	private int drawPosX;
	private int drawPosY;
	protected boolean movement;
	protected String image;
	private int player;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public GameElement() {

	}

	public GameElement(int player, int posX, int posY, boolean movement, String image) {
		
		this.player = player;
		this.posX = posX;
		this.posY = posY;
		this.movement = movement;
		this.image = image;
		
	}
	
	public void updateDrawPos() {
		
		Coordinate coord = Logic.fromMatrixToCoordinate(posX, posY);
		drawPosX = coord.getX();
		drawPosY = coord.getY();
		
	}
	// -------------------------------------
	// Methods
	// -------------------------------------
	public abstract void move(int[][] gameBoard);
	
	public abstract void collision();

	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean isMovement() {
		return movement;
	}

	public void setMovement(boolean movement) {
		this.movement = movement;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getDrawPosX() {
		return drawPosX;
	}

	public void setDrawPosX(int drawPosX) {
		this.drawPosX = drawPosX;
	}

	public int getDrawPosY() {
		return drawPosY;
	}

	public void setDrawPosY(int drawPosY) {
		this.drawPosY = drawPosY;
	}

}
