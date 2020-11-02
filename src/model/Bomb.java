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
public class Bomb extends GameCharacter{
	
	// -------------------------------------
    // Constants
    // -------------------------------------
	public final static String HUMAN_BOMB_SPRITE_1 = "hbs1";
	public final static String HUMAN_BOMB_SPRITE_2 = "hbs2";
	public final static String HUMAN_BOMB_SPRITE_3 = "hbs3";
	public final static String ALIEN_BOMB_SPRITE_1 = "abs1";
	public final static String ALIEN_BOMB_SPRITE_2 = "abs2";
	public final static String ALIEN_BOMB_SPRITE_3 = "abs3";
	public final static String BOMB_SPRITE_4 = "bs4";
	public final static String BOMB_SPRITE_5 = "bs5";
	public final static String BOMB_SPRITE_6 = "bs6";
	
	// -------------------------------------
	// Attributes
	// -------------------------------------
	private int blastRadius;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Bomb() {
		
	}
	
	public Bomb(int player, int posX, int posY, boolean movement, String image, int lives, int sprite, int isAlive, int cost, int blastRadius) {
		
		super(player, posX, posY, movement, image, lives, sprite, isAlive, cost);
		
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
