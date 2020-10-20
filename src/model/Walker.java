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
 * This class will represent any infantry unit of both human and alien.
 */
public class Walker extends Character{
	
	// -------------------------------------
	// Attributes
	// -------------------------------------
	private char direction;
	private int damage;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Walker() {
		
	}
	
	public Walker(int posX, int posY, boolean movement, String image, int lives, int sprite, boolean isAlive, char direction, int damage) {
		
		super(posX, posY, movement, image, lives, sprite, isAlive);
		this.direction = direction;
		this.damage = damage;
		
	}
	
	// -------------------------------------
	// Methods
	// -------------------------------------
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSprite() {
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
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
