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
 * This class will represent player number.
 */
public class PlayerNumber {

    private String type = "PlayerNumber";

    // -------------------------------------
    // Atributtes
    // -------------------------------------
    private String id;
    private int playerNumber;
    private String description;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public PlayerNumber(){

    }

    public PlayerNumber(String id, int playerNumber, String description){

        this.id = id;
        this.playerNumber = playerNumber;
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

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}