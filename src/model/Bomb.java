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
 * This class represents any explosive element of the game
 */
public class Bomb extends Character{
	
	// -------------------------------------
	// Attributes
	// -------------------------------------
	private int blastRadius;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Bomb() {
		
	}
	
	public Bomb(int posX, int posY, boolean movement, String image, int lives, int sprite, boolean isAlive, int cost, int blastRadius) {
		
		super(posX, posY, movement, image, lives, sprite, isAlive, cost);
		
	}
	
	// -------------------------------------
	// Methods
	// -------------------------------------
	@Override
	public void updateSprite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collision() {
		// TODO Auto-generated method stub
		
	}


	// -------------------------------------
	// Getters and setters 
	// -------------------------------------
	public int getBlastRadius() {
		return blastRadius;
	}

	public void setBlastRadius(int blastRadius) {
		this.blastRadius = blastRadius;
	}
		
}
