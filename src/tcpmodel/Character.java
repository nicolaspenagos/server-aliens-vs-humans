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
 * This class will represent the character pressed by the player.
 */
public class Character {

    private String type = "Character";

    // -------------------------------------
    // Constants
    // -------------------------------------
    public final static int HUMAN_WALKER_PRESSED = 0;
    public final static int HUMAN_BOMB_PRESSED = 1;
    public final static int HUMAN_SHOOTER_PRESSED = 2;
    public final static int ALIEN_WALKER_PRESSED = 3;
    public final static int ALIEN_BOMB_PRESSED = 4;
    public final static int ALIEN_SHOOTER_PRESSED = 5;

    // -------------------------------------
    // Atributtes
    // -------------------------------------
    private String id;
    private int pressed;
    private String description;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public Character(){
        
    }
    
    public Character(String id, int pressed, String description){
        
        this.id = id;
        this.pressed = pressed;
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

    public int getPressed() {
        return pressed;
    }

    public void setPressed(int pressed) {
        this.pressed = pressed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
