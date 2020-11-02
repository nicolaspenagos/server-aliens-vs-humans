/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.util.ArrayList;

import tcpmodel.Direction;
import model.GameCharacter;

/*
 * This class represents all the logic of the videogame
 */
public class Logic {
	
	// -------------------------------------
	// Constants
	// -------------------------------------
	public final static int MATRIX_SQUARE_SIZE = 73;
	public final static int COLUMN_GAP = 10;
	public final static int ROW_GAP = 16;
	public final static int LEFT_LIMIT = 0;
	public final static int MATRIX_ROW_SIZE = 5;
	public final static int MATRIX_COLUMN_SIZE = 9;
	
	// -------------------------------------
	// Attributes
	// -------------------------------------
	private ArrayList<GameElement> gameCharacters;
	private int[][] gameBoard;
	private Player player1;
	private Player player2;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Logic() {
		
		gameCharacters = new ArrayList<GameElement>();
		gameBoard = new int[5][9];
		
		player1 = new Player(Player.PLAYER1);
		player2 = new Player(Player.PLAYER2);
				
	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	public void moveGameElements() {
		
		for(int i=0; i<gameCharacters.size(); i++) {
			gameCharacters.get(i).move(gameBoard);
		}
		
	}
	
	public static Coordinate fromMatrixToCoordinate(int j, int i) {
		
		int x = 229 + (j*MATRIX_SQUARE_SIZE) + (j*COLUMN_GAP);
		int y = 179 + (i*MATRIX_SQUARE_SIZE) + (i*ROW_GAP);
		
		return new Coordinate(x,y);
		
	}
	
	public void playerMove(int player, Direction direction) {
		
		Coordinate toConvert, converted;
		
		if(player == Player.PLAYER1) {
			
			player1.updatePos(direction.getDirection());
			
			toConvert = player1.getCurrentPos();
			converted = fromMatrixToCoordinate(toConvert.getX(), toConvert.getY());
			converted.setX(converted.getX()-22);
			converted.setY(converted.getY()-22);
			
			player1.setDrawPos(converted);
			
			
		}else if(player == Player.PLAYER2) {
			
			getPlayer2().updatePos(direction.getDirection());
			
			toConvert = getPlayer2().getCurrentPos();
			converted = fromMatrixToCoordinate(toConvert.getX(), toConvert.getY());
			converted.setX(converted.getX()-22);
			converted.setY(converted.getY()-22);
			
			getPlayer2().setDrawPos(converted);
			
		}
		
	}
	
	public void addStars(int i) {
		
		if(i == Player.PLAYER1) {
			player1.addStar();
		}else if(i == Player.PLAYER2) {
			player2.addStar();
		}
		
	}
	
	public void putCharacter(int player) {
		
		boolean put;
		
		if(player == Player.PLAYER1) 
			put = player1.putCharacter();
		else if(player == Player.PLAYER2) 
			put = player2.putCharacter();
		else
			put = false;
		
		if(put) {
			
			GameElement gameCharacter;
			
			
			if(player == Player.PLAYER1) {
				
				if(player1.getCurrentCharacter()==GameCharacter.HUMAN_WALKER) {
					gameCharacter = new Walker(player, player1.getCurrentPos().getX(), player1.getCurrentPos().getY(), true, Walker.HUMAN_WALKER_SPRITE_1, 5, 0, GameCharacter.ALIVE, 100, 'R', 1);
					gameCharacters.add(gameCharacter);
					gameCharacter.move(gameBoard);
				}
				
				if(player1.getCurrentCharacter()==GameCharacter.HUMAN_SHOOTER) {
					gameCharacter = new Shooter(player, player1.getCurrentPos().getX(), player1.getCurrentPos().getY(), true, Shooter.HUMAN_SHOOTER_SPRITE_1, 5, 0, GameCharacter.ALIVE, 100, 'R', 500, gameCharacters);
					gameCharacters.add(gameCharacter);
					//Shooter s = (Shooter) gameCharacter;
					//gameCharacters.add(s.getBullet());
				}
				
				if(player1.getCurrentCharacter() == GameCharacter.HUMAN_BOMB) {
					//int player, int posX, int posY, boolean movement, String image, int lives, int sprite, int isAlive, int cost, int blastRadius
					System.out.println();
					gameCharacter = new Bomb(player,player1.getCurrentPos().getX(), player1.getCurrentPos().getY(), false, Bomb.HUMAN_BOMB_SPRITE_1, 5, 0, GameCharacter.ALIVE, 50, 1, gameCharacters);
					gameCharacters.add(gameCharacter);
				}
				
				
				
			}else{
				
				if(player2.getCurrentCharacter()==GameCharacter.ALIEN_WALKER) {
					
					gameCharacter = new Walker(player, player2.getCurrentPos().getX(), player2.getCurrentPos().getY(), true, Walker.ALIEN_WALKER_SPRITE_1, 5, 0, GameCharacter.ALIVE, 100, 'L', 1);
					gameCharacters.add(gameCharacter);
					gameCharacter.move(gameBoard);
					
				}
				
				if(player2.getCurrentCharacter()==GameCharacter.ALIEN_SHOOTER) {
					gameCharacter = new Shooter(player, player2.getCurrentPos().getX(), player2.getCurrentPos().getY(), true, Shooter.ALIEN_SHOOTER_SPRITE_1, 5, 0, GameCharacter.ALIVE, 100, 'L', 500,  gameCharacters);
					gameCharacters.add(gameCharacter);
				}
				
				if(player2.getCurrentCharacter() == GameCharacter.ALIEN_BOMB) {
					//int player, int posX, int posY, boolean movement, String image, int lives, int sprite, int isAlive, int cost, int blastRadius
					System.out.println();
					gameCharacter = new Bomb(player,player2.getCurrentPos().getX(), player2.getCurrentPos().getY(), false, Bomb.ALIEN_BOMB_SPRITE_1, 5, 0, GameCharacter.ALIVE, 50, 1 ,gameCharacters);
					gameCharacters.add(gameCharacter);
				}
				
				
			}
				
			
			
			
		}
	
	}
		
	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public ArrayList<GameElement> getItemsToDraw() {
		return gameCharacters;
	}

	public void setItemsToDraw(ArrayList<GameElement> gameElements) {
		this.gameCharacters = gameElements;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}	

}
