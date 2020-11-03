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
 * This class represents the score of any player.
 */
public class Score {

	private String type = "Score";

	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private String id;
	private int score;
	private String description;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Score() {
		
	}
	
	public Score(String id, int score, String description) {
		
		this.id = id;
		this.score = score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
