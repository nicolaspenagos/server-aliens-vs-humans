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
 * This class will represent any artillery unit of both human and alien.
 */
public class Shooter extends Character{

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private char direction;
	private int rateOfFire;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Shooter() {
		
	}
	
	public Shooter(int posX, int posY, boolean movement, String image, int lives, int sprite, boolean isAlive, char direction, int rateOfFire) {
		
		super(posX, posY, movement, image, lives, sprite, isAlive);
		this.direction = direction;
		this.rateOfFire = rateOfFire;
		
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
	public char getDirection() {
		return direction;
	}
	
	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getRateOfFire() {
		return rateOfFire;
	}

	public void setRateOfFire(int rateOfFire) {
		this.rateOfFire = rateOfFire;
	}

}
