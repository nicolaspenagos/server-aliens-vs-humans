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

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.google.gson.Gson;

import customsThreads.StarThread;
import events.OnMessageListener;
import tcpmodel.Direction;
import tcpmodel.Generic;
import tcpmodel.Put;
import tcpmodel.Star;
import tcpmodel.Character;
import model.Bomb;
import model.Bullet;
import model.Coordinate;
import model.GameCharacter;
import model.GameElement;
import model.Logic;
import model.Player;
import model.Shooter;
import model.Walker;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

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
	private int animationCounter;
	private int currentCharacter;

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
	private PImage humans_walker_feedback;
	private PImage human_shooter_feedback;
	private PImage human_bomb_feedback;
	private PImage alien_walker_feedback;
	private PImage alien_shooter_feedback;
	private PImage alien_bomb_feedback;
	private PImage aliens_feedback_shadow;
	private PImage player1;
	private PImage player2;
	private PImage human_walker_sprite1;
	private PImage human_walker_sprite2;
	private PImage human_walker_sprite3;
	private PImage alien_walker_sprite1;
	private PImage alien_walker_sprite2;
	private PImage alien_walker_sprite3;
	private PImage bullet_sprite;
	private PImage bullet_sprite1;
	private PImage human_bomb_sprite1;
	private PImage human_bomb_sprite2;
	private PImage human_bomb_sprite3;
	private PImage alien_bomb_sprite1;
	private PImage alien_bomb_sprite2;
	private PImage alien_bomb_sprite3;
	private PImage bomb_sprite4;
	private PImage bomb_sprite5;
	private PImage bomb_sprite6;
	private PImage human_shooter_sprite;
	private PImage alien_shooter_sprite;

	private PImage[] animationArray;

	// -------------------------------------
	// Fonts
	// -------------------------------------
	private PFont englebert;

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
		animationCounter = 0;

		tcp = TCPLauncher.getInstance();
		tcp.setObserver(this);
		tcp.start();

		gson = new Gson();
		englebert = createFont("fonts/Englebert-Regular.ttf", 32);

		// Load images
		game_background = loadImage("images/game_background.png");
		intro_background = loadImage("images/background.png");
		player1 = loadImage("images/player1.png");
		player2 = loadImage("images/player2.png");

		animationArray = new PImage[4];
		animationArray[0] = loadImage("images/lets_connect.png");
		animationArray[1] = loadImage("images/start_battle_3.png");
		animationArray[2] = loadImage("images/start_battle_2.png");
		animationArray[3] = loadImage("images/start_battle_1.png");

	}

	public void draw() {

		if (startGame) {

			image(game_background, 0, 0);

			Coordinate player1Shadow = gameLogic.getPlayer1().getDrawPos();
			Coordinate player2Shadow = gameLogic.getPlayer2().getDrawPos();

			image(humans_feedback_shadow, player1Shadow.getX(), player1Shadow.getY());
			image(aliens_feedback_shadow, player2Shadow.getX(), player2Shadow.getY());

			textFont(englebert);
			text("" + gameLogic.getPlayer1().getStars(), 130, 91);
			text("" + gameLogic.getPlayer1().getScore(), 284, 91);
			text("" + gameLogic.getPlayer2().getStars(), 1068, 91);
			text("" + gameLogic.getPlayer2().getScore(), 895, 91);

			for (int i = 0; i < gameLogic.getItemsToDraw().size(); i++) {

				GameElement current = gameLogic.getItemsToDraw().get(i);
				
				if(current instanceof GameCharacter) {
					
					GameCharacter currentGameCharacter = (GameCharacter) current;
					
					if(currentGameCharacter.getState() == GameCharacter.EMPTY || currentGameCharacter.getState() == GameCharacter.GONE || currentGameCharacter.getState() == GameCharacter.KILLED) {
						
						gameLogic.getItemsToDraw().remove(i);
						int currentPlayer = currentGameCharacter.getPlayer();
						
						if(currentGameCharacter.getState()==GameCharacter.GONE) {
							if(currentPlayer == Player.PLAYER1)
								gameLogic.getPlayer1().setScore(gameLogic.getPlayer1().getScore()+10);
							else if(currentPlayer == Player.PLAYER2)
								gameLogic.getPlayer2().setScore(gameLogic.getPlayer2().getScore()+10);
						}
						
					}else {
						
						String image = current.getImage();
						PImage currentImage = getImage(image);
						
						if(image.equals(Shooter.HUMAN_SHOOTER_SPRITE_1) ||image.equals(Shooter.ALIEN_SHOOTER_SPRITE_1) ) {
							System.out.println("Holaaaaaa");
							image(currentImage, current.getDrawPosX(), current.getDrawPosY());
							Shooter shooter = (Shooter) current;
							Bullet b = shooter.getBullet();
							PImage bi = getImage(b.getImage());
							
							image(bi, b.getDrawPosX(), b.getDrawPosY());
							
							
						}else {
						
							image(currentImage, current.getDrawPosX(), current.getDrawPosY());
		
						}
						
					}
				}
				
				

			}

		} else {

			image(intro_background, 0, 0);
			image(animationArray[animationCounter], 405, 426);
			image(player1, 433, 480);
			image(player2, 593, 480);

		}

	}

	public void mousePressed() {
		System.out.println(mouseX + "  " + mouseY);
	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	public void moveGameElements() {
		gameLogic.moveGameElements();
	}

	public void updateImages() {

	}

	public void loadGameImages() {

		humans_walker_feedback = loadImage("images/human_walker_feedback.png");
		human_shooter_feedback = loadImage("images/human_shooter_feedback.png");
		human_bomb_feedback = loadImage("images/human_bomb_feedback.png");
		humans_feedback_shadow = loadImage("images/humans_feedback_shadow.png");
		aliens_feedback_shadow = loadImage("images/aliens_feedback_shadow.png");
		alien_walker_feedback = loadImage("images/alien_walker_feedback.png");
		alien_shooter_feedback = loadImage("images/alien_shooter_feedback.png");
		alien_bomb_feedback = loadImage("images/alien_bomb_feedback.png");
		human_walker_sprite1 = loadImage("images/hws1.png");
		human_walker_sprite2 = loadImage("images/hws2.png");
		human_walker_sprite3 = loadImage("images/hws3.png");
		alien_walker_sprite1 = loadImage("images/aws1.png");
		alien_walker_sprite2 = loadImage("images/aws2.png");
		alien_walker_sprite3 = loadImage("images/aws3.png");
		human_shooter_sprite = loadImage("images/hss1.png");
		alien_shooter_sprite = loadImage("images/ass1.png");
		bullet_sprite = loadImage("images/bs.png");
		bullet_sprite1 = loadImage("images/bs1.png");
		human_bomb_sprite1 = loadImage("images/hbs1.png");
		human_bomb_sprite2 = loadImage("images/hbs2.png");
		human_bomb_sprite3 = loadImage("images/hbs3.png");
		alien_bomb_sprite1 = loadImage("images/abs1.png");
		alien_bomb_sprite2 = loadImage("images/abs2.png");
		alien_bomb_sprite3 = loadImage("images/abs3.png");
		bomb_sprite4 = loadImage("images/bs4.png");
		bomb_sprite5 = loadImage("images/bs5.png");
		bomb_sprite6 = loadImage("images/bs6.png");
		
	}

	public void feedbackImageManager() {

		switch (currentCharacter) {

		case Character.HUMAN_WALKER_PRESSED:
			humans_feedback_shadow = humans_walker_feedback;
			break;

		case Character.HUMAN_SHOOTER_PRESSED:
			humans_feedback_shadow = human_shooter_feedback;
			break;

		case Character.HUMAN_BOMB_PRESSED:
			humans_feedback_shadow = human_bomb_feedback;

			break;
		case Character.ALIEN_WALKER_PRESSED:
			aliens_feedback_shadow = alien_walker_feedback;
			break;

		case Character.ALIEN_SHOOTER_PRESSED:
			aliens_feedback_shadow = alien_shooter_feedback;
			break;

		case Character.ALIEN_BOMB_PRESSED:
			aliens_feedback_shadow = alien_bomb_feedback;
			break;
			
			

		}

	}

	public void launchStar(String time) {

		Star star = new Star(UUID.randomUUID().toString(), "Star that will be catched for a player");
		star.setOwner(3);
		String json = gson.toJson(star);

		int player = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		isStarCatched = false;

		if (player == Player.PLAYER1) {

			tcp.getSession1().sendMessage(json);
			tcp.getSession2().sendMessage(json);

		} else if (player == Player.PLAYER2) {

			tcp.getSession2().sendMessage(json);
			tcp.getSession1().sendMessage(json);

		}

	}

	public void startGame() {

		starThread = new StarThread(this);
		starThread.setDaemon(true);
		starThread.start();

	}

	public PImage getImage(String image) {

		switch (image) {

		case Walker.HUMAN_WALKER_SPRITE_1:
			return human_walker_sprite1;

		case Walker.HUMAN_WALKER_SPRITE_2:
			return human_walker_sprite2;

		case Walker.HUMAN_WALKER_SPRITE_3:
			return human_walker_sprite3;

		case Walker.ALIEN_WALKER_SPRITE_1:
			return alien_walker_sprite1;

		case Walker.ALIEN_WALKER_SPRITE_2:
			return alien_walker_sprite2;

		case Walker.ALIEN_WALKER_SPRITE_3:
			return alien_walker_sprite3;
			
		case Shooter.HUMAN_SHOOTER_SPRITE_1:
			return human_shooter_sprite;
			
		case Shooter.ALIEN_SHOOTER_SPRITE_1:
			return alien_shooter_sprite;
			
		case Bullet.BULLET_SPRITE:
			return bullet_sprite;
			
		case Bullet.BULLET_SPRITE1:
			return bullet_sprite1;
			
		case Bomb.HUMAN_BOMB_SPRITE_1:
			return human_bomb_sprite1;

		case Bomb.HUMAN_BOMB_SPRITE_2:
			return human_bomb_sprite2;

		case Bomb.HUMAN_BOMB_SPRITE_3:
			return human_bomb_sprite3;
			
		case Bomb.ALIEN_BOMB_SPRITE_1:
			return alien_bomb_sprite1;

		case Bomb.ALIEN_BOMB_SPRITE_2:
			return alien_bomb_sprite2;

		case Bomb.ALIEN_BOMB_SPRITE_3:
			return alien_bomb_sprite3;
			
		case Bomb.BOMB_SPRITE_4:
			return bomb_sprite4;
			
		case Bomb.BOMB_SPRITE_5:
			return bomb_sprite5;
			
		case Bomb.BOMB_SPRITE_6:
			return bomb_sprite6;

		}

		return null;

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

			if (player == Player.PLAYER1)
				gameLogic.playerMove(Player.PLAYER1, direction);
			else if (player == Player.PLAYER2)
				gameLogic.playerMove(Player.PLAYER2, direction);

			break;

		case "PlayerNumber":

			playerCounter++;

			if (playerCounter == 1) {
				player1 = loadImage("images/player1_connected.png");

			} else if (playerCounter == 2) {

				player2 = loadImage("images/player2_connected.png");
				loadGameImages();

				new Thread(

						() -> {

							int i = 0;
							while (i < 4) {

								try {

									animationCounter = i;
									Thread.sleep(1000);
									i++;

								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}

							startGame = true;
							startGame();

						}

				).start();

			}

			break;

		case "Star":

			Star star = gson.fromJson(json, Star.class);

			if (!isStarCatched) {

				isStarCatched = true;
				gameLogic.addStars(star.getOwner());

				Star feedbackStar = new Star(UUID.randomUUID().toString(), "Feedback owner star");
				feedbackStar.setOwner(Star.OWNED_STAR);

				if (star.getOwner() == Player.PLAYER1)
					tcp.getSession2().sendMessage(gson.toJson(feedbackStar));
				else if (star.getOwner() == Player.PLAYER2)
					tcp.getSession1().sendMessage(gson.toJson(feedbackStar));

			}

			break;

		case "Character":

			Character character = gson.fromJson(json, Character.class);
			currentCharacter = character.getPressed();
			feedbackImageManager();

			if (currentCharacter < 3) {
				gameLogic.getPlayer1().setCurrentCharacter(character.getPressed());
			} else {
				gameLogic.getPlayer2().setCurrentCharacter(character.getPressed());
			}

			break;

		case "Put":

			if (player == Player.PLAYER1)
				gameLogic.putCharacter(Player.PLAYER1);
			else if (player == Player.PLAYER2)
				gameLogic.putCharacter(Player.PLAYER2);

			break;

		}
	}

}
