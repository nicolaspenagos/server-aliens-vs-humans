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
 * This class represents any explosive element of the game
 */
public class Bomb extends GameCharacter {

	// -------------------------------------
	// Constants
	// -------------------------------------
	public final static String HUMAN_BOMB_SPRITE_1 = "hbs1";
	public final static String HUMAN_BOMB_SPRITE_2 = "hbs2";
	public final static String HUMAN_BOMB_SPRITE_3 = "hbs3";
	public final static String ALIEN_BOMB_SPRITE_1 = "abs1";
	public final static String ALIEN_BOMB_SPRITE_2 = "abs2";
	public final static String ALIEN_BOMB_SPRITE_3 = "abs3";
	public final static String BOMB_SPRITE_4 = "bs4";
	public final static String BOMB_SPRITE_5 = "bs5";
	public final static String BOMB_SPRITE_6 = "bs6";

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private int blastRadius;
	private int p;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Bomb() {

	}

	public Bomb(int player, int posX, int posY, boolean movement, String image, int lives, int sprite, int isAlive,
			int cost, int blastRadius, ArrayList<GameElement> characters) {

		super(player, posX, posY, movement, image, lives, sprite, isAlive, cost);
		p = player;
		super.updateDrawPos();
		collision(characters);
	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	@Override
	public void updateSprite() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(int[][] gameBoard) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collision(ArrayList<GameElement> characters) {
		// TODO Auto-generated method stub

		new Thread(

				() -> {

					boolean kill = false;
					while (!kill) {

						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < characters.size(); i++) {

							if (p == Player.PLAYER1) {
								if (characters.get(i).getImage().equals(Walker.ALIEN_WALKER_SPRITE_1)
										|| characters.get(i).getImage().equals(Walker.ALIEN_WALKER_SPRITE_2)
										|| characters.get(i).getImage().equals(Walker.ALIEN_WALKER_SPRITE_3)) {
									double dist = Math.sqrt(((super.getDrawPosX() - characters.get(i).getDrawPosX())
											* (super.getDrawPosX() - characters.get(i).getDrawPosX()))
											+ ((super.getDrawPosY() - characters.get(i).getDrawPosY())
													* (super.getDrawPosY() - characters.get(i).getDrawPosY())));
									if (dist < 80) {
										
										kill = true;
										boomb();
										characters.remove(i);

									}
								}

							} else {
								System.out.println("hHola");
								if (characters.get(i).getImage().equals(Walker.HUMAN_WALKER_SPRITE_1)
										|| characters.get(i).getImage().equals(Walker.HUMAN_WALKER_SPRITE_2)
										|| characters.get(i).getImage().equals(Walker.HUMAN_WALKER_SPRITE_3)) {
									System.out.println("hHola1");
									double dist = Math.sqrt(((super.getDrawPosX() - characters.get(i).getDrawPosX())
											* (super.getDrawPosX() - characters.get(i).getDrawPosX()))
											+ ((super.getDrawPosY() - characters.get(i).getDrawPosY())
													* (super.getDrawPosY() - characters.get(i).getDrawPosY())));
									if (dist < 80) {
										
										kill = true;
										boomb();
										characters.remove(i);

									}
								}

							}

						}

					}

				}

		).start();

	}

	public void boomb() {

		new Thread(() -> {

		
			try {
				super.image = BOMB_SPRITE_4;
				Thread.sleep(100);
				super.image = BOMB_SPRITE_5;
				Thread.sleep(100);
				super.image = BOMB_SPRITE_6;
				Thread.sleep(100);
				super.state = GameCharacter.GONE;
				super.state = GameCharacter.GONE;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		).start();
	}

	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public int getBlastRadius() {
		return blastRadius;
	}

	public void setBlastRadius(int blastRadius) {
		this.blastRadius = blastRadius;
	}

}
