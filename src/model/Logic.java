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
	
	// -------------------------------------
	// Attributes
	// -------------------------------------
	private ArrayList<GameElement> gameElements;
	private int[][] gameBoard;
	private Player player1;
	private Player player2;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Logic() {
		
		gameElements = new ArrayList<GameElement>();
		gameBoard = new int[5][9];
		
		player1 = new Player(Player.PLAYER1);
		player2 = new Player(Player.PLAYER2);
				
	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	public Coordinate fromMatrixToCoordinate(int i, int j) {
		
		int x = 229 + (j*MATRIX_SQUARE_SIZE) + (j*COLUMN_GAP);
		int y = 179 + (i*MATRIX_SQUARE_SIZE) + (i*ROW_GAP);
		
		return new Coordinate(x,y);
		
	}
	
	public void playerMove(int player, Direction direction) {
		
		if(player == Player.PLAYER1) {
			player1.updatePos(direction.getDirection());
		}else if(player == Player.PLAYER2) {
			player2.updatePos(direction.getDirection());
		}
		
	}
	
	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public ArrayList<GameElement> getItemsToDraw() {
		return gameElements;
	}

	public void setItemsToDraw(ArrayList<GameElement> gameElements) {
		this.gameElements = gameElements;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}	

}
