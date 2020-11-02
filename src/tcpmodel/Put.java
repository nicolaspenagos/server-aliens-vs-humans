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
 * This class represents the action of put a character.
 */
public class Put {

	private String type = "Put";

	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private String id;
	private String description;

	// -------------------------------------
	// Constructors
	// -------------------------------------
	public Put() {

	}
	
	public Put(String id, String description) {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
