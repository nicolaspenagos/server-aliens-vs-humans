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
 * This class will represent any coordinate of the screen.
 */
public class Coordinate {
	
	// -------------------------------------
	// Attributes
	// -------------------------------------
	private int x;
	private int y;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Coordinate(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}

	// -------------------------------------
	// Gettes and setters
	// -------------------------------------
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
