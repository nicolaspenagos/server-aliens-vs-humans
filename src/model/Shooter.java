/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.util.ArrayList;

/*
 * This class will represent any artillery unit of both human and alien.
 */
public class Shooter extends GameCharacter{
	
	// -------------------------------------
    // Constants
    // -------------------------------------
	public final static String HUMAN_SHOOTER_SPRITE_1 = "hss1";
	public final static String ALIEN_SHOOTER_SPRITE_1 = "ass1";

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private char direction;
	private int rateOfFire;
	private Bullet bullet;
	
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Shooter() {
		
	}
	
	public Shooter(int player, int posX, int posY, boolean movement, String image, int lives, int sprite, int isAlive, int cost, char direction, int rateOfFire, ArrayList<GameElement> gameCharacters) {
		
		super(player, posX, posY, movement, image, lives, sprite, isAlive, cost);
		this.direction = direction;
		this.rateOfFire = rateOfFire;
		
		setBullet(new Bullet(player, posX, posY, true, Bullet.BULLET_SPRITE));
		bullet.collision(gameCharacters);
		
		super.updateDrawPos();
		
	}
	
	// -------------------------------------
	// Methods
	// -------------------------------------
	@Override
	public void updateSprite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int[][] gameBoard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collision(ArrayList<GameElement> characters) {
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

	public Bullet getBullet() {
		return bullet;
	}

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}

}
