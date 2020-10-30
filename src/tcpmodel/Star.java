/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package tcpmodel;

import model.Player;

/*
 * This class represents a star of the game.
 */
public class Star {
	
	private String type = "Star";
	
	// -------------------------------------
	// Constants 
	// -------------------------------------
	public final static int OWNED_STAR = -1;
	
	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private String id;
	private int owner;
	private String description;
	
	// -------------------------------------
	// Constructors
	// -------------------------------------
	public Star() {
		
	}
	
	public Star(String id, String description) {
		
		this.id = id;
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
	
	public int getOwner() {
		return owner;
	}
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
