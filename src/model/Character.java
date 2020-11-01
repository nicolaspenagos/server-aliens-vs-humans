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
    // Constants
    // -------------------------------------
    public final static int HUMAN_WALKER = 0;
    public final static int HUMAN_BOMB = 1;
    public final static int HUMAN_SHOOTER = 2;
    public final static int ALIEN_WALKER = 3;
    public final static int ALIEN_BOMB = 4;
    public final static int ALIEN_SHOOTER = 5;
    
    public final static int WALKER_PRICE = 100;
    public final static int SHOOTER_PRICE = 200;
    public final static int BOMB_PRICE = 50;

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private int lives;
	private int sprite;
	private boolean isAlive;
	private int cost;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Character() {
		
	}
	
	public Character(int posX, int posY, boolean movement, String image, int lives, int sprite, boolean isAlive, int cost) {
		
		super(posX, posY, movement, image);
		this.lives = lives;
		this.sprite = sprite;
		this.isAlive = isAlive;
		this.cost = cost;
		
	}
	
	// -------------------------------------
	// Methods
	// -------------------------------------
	public abstract void updateSprite();
	
	public static int getPrice(int character) {
		
		if(character == HUMAN_WALKER || character == ALIEN_WALKER) 
			return WALKER_PRICE;
		else if(character == HUMAN_SHOOTER || character == ALIEN_SHOOTER) 
			return SHOOTER_PRICE;
		else if(character == HUMAN_BOMB || character == ALIEN_BOMB) 
			return BOMB_PRICE;
		else 
			return -1;
		
	}
	
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
