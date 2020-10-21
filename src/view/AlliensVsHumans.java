/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package view;

import com.google.gson.Gson;

import events.OnMessageListener;
import tcpmodel.Direction;
import tcpmodel.Generic;
import model.Logic;
import model.Player;
import processing.core.PApplet;
import processing.core.PImage;

/*
 * This is the main class, here is the implementation of the proccesing technology as a tool for drawing the video game
 */
public class AlliensVsHumans extends PApplet implements OnMessageListener {

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private TCPLauncher tcp;
	private Gson gson;
	private Logic gameLogic;

	// -------------------------------------
	// Images
	// -------------------------------------
	private PImage intro_background;
	private PImage game_background;

	// -------------------------------------
	// Main method
	// -------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.AlliensVsHumans");
	}

	// -------------------------------------
	// Processing methods
	// -------------------------------------
	public void settings() {
		size(1200, 700);
	}

	public void setup() {

		gameLogic = new Logic();

		tcp = TCPLauncher.getInstance();
		tcp.setObserver(this);
		tcp.start();

		gson = new Gson();

		// Load images
		game_background = loadImage("images/game_background.png");

	}

	public void draw() {
		image(game_background, 0, 0);
	}

	public void mousePressed() {
		System.out.println(mouseX + "  " + mouseY);
	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	public void updateImages() {

	}

	// -------------------------------------
	// TCP
	// -------------------------------------
	@Override
	public void OnMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		// tcp.getSession1().sendMessage("Hi back");

		Generic generic = gson.fromJson(msg, Generic.class);

		switch (generic.type) {
		
			case "Direction":
				
				Direction direction = gson.fromJson(msg, Direction.class);
				gameLogic.playerMove(Player.PLAYER1, direction);
				
				break;
		}

	}

}
