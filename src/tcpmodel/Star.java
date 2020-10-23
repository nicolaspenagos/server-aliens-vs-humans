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
	// Atributtes
	// -------------------------------------
	private String id;
	private Player owner;
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
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
