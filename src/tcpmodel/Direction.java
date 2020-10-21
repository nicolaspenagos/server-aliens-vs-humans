/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package tcpmodel;

/*
 * This class represents the direction of any movement of any player.
 */
public class Direction {

	private String type = "Direction";
	  
	// -------------------------------------
	// Constants
	// -------------------------------------
	public final static char UP = 'U';
	public final static char DOWN = 'D';
	public final static char RIGHT = 'R';
	public final static char LEFT = 'L';

	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private String id;
	private char direction;
	private String description;

	// -------------------------------------
	// Constructors
	// -------------------------------------
	public Direction() {

	}

	public Direction(String id, char direction, String description) {

		this.id = id;
		this.direction = direction;
		this.description = description;

	}

	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
