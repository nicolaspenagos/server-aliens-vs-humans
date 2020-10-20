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
	private int posX;
	private int posY;
	private boolean movement;
	private String image;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public GameElement() {

	}

	public GameElement(int posX, int posY, boolean movement, String image) {
		
		this.posX = posX;
		this.posY = posY;
		this.movement = movement;
		this.image = image;
		
	}
	
	// -------------------------------------
	// Methods
	// -------------------------------------
	public abstract void move();
	
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

}
