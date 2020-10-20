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
 * This class will represents any character human or alien.
 */
public abstract class Character extends GameElement{

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private int lives;
	private int sprite;
	private boolean isAlive;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Character() {
		
	}
	
	public Character(int posX, int posY, boolean movement, String image, int lives, int sprite, boolean isAlive) {
		
		super(posX, posY, movement, image);
		this.lives = lives;
		this.sprite = sprite;
		this.isAlive = isAlive;
		
	}
	
	// -------------------------------------
	// Methods
	// -------------------------------------
	public abstract void updateSprite();
	
	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public int getLives() {
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public int getSprite() {
		return sprite;
	}
	
	public void setSprite(int sprite) {
		this.sprite = sprite;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
