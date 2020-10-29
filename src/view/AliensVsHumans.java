/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package view;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.google.gson.Gson;

import customsThreads.StarThread;
import events.OnMessageListener;
import tcpmodel.Direction;
import tcpmodel.Generic;
import tcpmodel.Star;
import model.Coordinate;
import model.Logic;
import model.Player;
import processing.core.PApplet;
import processing.core.PImage;

/*
 * This is the main class, here is the implementation of the proccesing technology as a tool for drawing the video game
 */
public class AliensVsHumans extends PApplet implements OnMessageListener {

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private TCPLauncher tcp;
	private Gson gson;
	private Logic gameLogic;
	private int playerCounter;
	private boolean startGame;
	private boolean isStarCatched;
	
	// -------------------------------------
	// Customs threads
	// -------------------------------------
	private StarThread starThread;

	// -------------------------------------
	// Images
	// -------------------------------------
	private PImage intro_background;
	private PImage game_background;
	private PImage humans_feedback_shadow;
	private PImage aliens_feedback_shadow;

	// -------------------------------------
	// Main method
	// -------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.AliensVsHumans");
	}

	// -------------------------------------
	// Processing methods
	// -------------------------------------
	public void settings() {
		size(1200, 700);
	}

	public void setup() {

		gameLogic = new Logic();
		
		playerCounter = 0;
		startGame = false;

		tcp = TCPLauncher.getInstance();
		tcp.setObserver(this);
		tcp.start();
		
		gson = new Gson();

		// Load images
		game_background = loadImage("images/game_background.png");
		humans_feedback_shadow = loadImage("images/humans_feedback_shadow.png");
		aliens_feedback_shadow = loadImage("images/aliens_feedback_shadow.png");
		
	}

	public void draw() {
		
		if(startGame) {
			
			image(game_background, 0, 0);
			
			Coordinate player1Shadow = gameLogic.getPlayer1().getDrawPos();
			Coordinate player2Shadow = gameLogic.getPlayer2().getDrawPos();
			
			image(humans_feedback_shadow, player1Shadow.getX(), player1Shadow.getY());
			image(aliens_feedback_shadow, player2Shadow.getX(), player2Shadow.getY());
			
		}
			
	}

	public void mousePressed() {
		System.out.println(mouseX + "  " + mouseY);
	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	public void updateImages() {

	}
	
	public void launchStar(String time) {
		
		System.out.println("AliensVsHumans 112: Star! "+time);
		
		Star star = new Star(UUID.randomUUID().toString(), "Star that will be catched for a player");
		star.setOwner(3);
		String json = gson.toJson(star);
		
		int player = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		isStarCatched = false;
		
		if(player == Player.PLAYER1) {
			
			tcp.getSession1().sendMessage(json);
			//tcp.getSession2().sendMessage(json);
			
		}else if(player == Player.PLAYER2) {
			
			//tcp.getSession2().sendMessage(json);
			tcp.getSession1().sendMessage(json);
			
		}
		
	}
	
	public void startGame() {
		
		starThread = new StarThread(this);
		starThread.setDaemon(true);
		starThread.start();
		
	}

	// -------------------------------------
	// TCP
	// -------------------------------------
	@Override
	public void OnMessageP1(String msg) {
		// TODO Auto-generated method stub	
		onMessage(msg, Player.PLAYER1);
	}

	@Override
	public void OnMessageP2(String msg) {
		// TODO Auto-generated method stub
		onMessage(msg, Player.PLAYER2);
	}
	
	public void onMessage(String json, int player) {
		
		Generic generic = gson.fromJson(json, Generic.class);

		switch (generic.type) {
		
			case "Direction":
				
				Direction direction = gson.fromJson(json, Direction.class);
				
				if(player == Player.PLAYER1)
					gameLogic.playerMove(Player.PLAYER1, direction);
				else if(player == Player.PLAYER2)
					gameLogic.playerMove(Player.PLAYER2, direction);
				
				break;
				
			case "PlayerNumber":
				
				playerCounter++;
				
				if(playerCounter == 1) {
					startGame = true;
					startGame();
				}
				
				
				
				break;
				
			case "Star":
				
				Star star = gson.fromJson(json, Star.class);
				
				if(!isStarCatched) {
					
					isStarCatched = true;
					gameLogic.addStars(star.getOwner());
		
				}
				
				break;
				
		}
	}

}
