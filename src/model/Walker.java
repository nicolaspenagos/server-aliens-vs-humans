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

/*
 * This class will represent any infantry unit of both human and alien.
 */
public class Walker extends GameCharacter {

	// -------------------------------------
	// Constants
	// -------------------------------------
	public final static String HUMAN_WALKER_SPRITE_1 = "hws1";
	public final static String HUMAN_WALKER_SPRITE_2 = "hws2";
	public final static String HUMAN_WALKER_SPRITE_3 = "hws3";
	public final static String ALIEN_WALKER_SPRITE_1 = "aws1";
	public final static String ALIEN_WALKER_SPRITE_2 = "aws2";
	public final static String ALIEN_WALKER_SPRITE_3 = "aws3";

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private char direction;
	private int damage;
	private int p;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Walker() {

	}

	public Walker(int player, int posX, int posY, boolean movement, String image, int lives, int sprite, int isAlive,
			int cost, char direction, int damage) {
	
		super(player, posX, posY, movement, image, lives, sprite, isAlive, cost);
		System.out.println("djnaksdjaksldjlas "+player);
		this.direction = direction;
		this.damage = damage;
		this.p =player;
		
		super.updateDrawPos();

	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	@Override
	public void move(int[][] gameBoard) {
		// TODO Auto-generated method stub

		new Thread(

				() -> {

					while (super.state == GameCharacter.ALIVE) {
						System.out.println("p: "+ p);
						int i = super.posY;
						int j = super.posX;

						if (p == Player.PLAYER1)
							super.image = HUMAN_WALKER_SPRITE_1;
						else
							super.image = ALIEN_WALKER_SPRITE_1;
						
						
						try {
							Thread.sleep(333);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					

						int mov = (p == Player.PLAYER1) ? 1 : -1;

						if (gameBoard[i][j + mov] != -1) {

							if (p == Player.PLAYER1) {

								if (j + mov < Logic.MATRIX_COLUMN_SIZE) {

									Coordinate temp0DrawPos = Logic.fromMatrixToCoordinate(j, i);
									j = j + mov;
									Coordinate temp1DrawPos = Logic.fromMatrixToCoordinate(j, i);
									
									super.setDrawPosX((temp0DrawPos.getX()+temp1DrawPos.getX())/2);
									super.image = HUMAN_WALKER_SPRITE_2;
									
									try {
										Thread.sleep(333);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									super.posX = j;
									super.posY = i;
									super.updateDrawPos();
									
									super.image = HUMAN_WALKER_SPRITE_3;

									if (j == Logic.MATRIX_COLUMN_SIZE - 1)
										state = GameCharacter.GONE;

								}

							} else if (p == Player.PLAYER2) {
							
								if (j + mov >= 0) {
								
									Coordinate temp0DrawPos = Logic.fromMatrixToCoordinate(j, i);
									j = j + mov;
									Coordinate temp1DrawPos = Logic.fromMatrixToCoordinate(j, i);
									
									super.setDrawPosX((temp0DrawPos.getX()+temp1DrawPos.getX())/2);
									super.image = ALIEN_WALKER_SPRITE_2;
									
									try {
										Thread.sleep(333);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									super.posX = j;
									super.posY = i;
									super.updateDrawPos();
									
									super.image = ALIEN_WALKER_SPRITE_3;
									
									if (j == 0)
										state = GameCharacter.GONE;

								}

							}

						} else {
							// ATACKKKK
						}

					}

				}

		).start();

	}

	public void attack() {

	}

	@Override
	public void collision(ArrayList<GameElement> characters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSprite() {
		// TODO Auto-generated method stub

	}

	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
