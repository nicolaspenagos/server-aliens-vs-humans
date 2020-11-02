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

public class Bullet extends GameElement {

	// -------------------------------------
	// Constants
	// -------------------------------------
	public final static String BULLET_SPRITE = "bs.png";
	public final static String BULLET_SPRITE1 = "bs1.png";

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private int p;
	private int startP;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Bullet() {
	}

	public Bullet(int player, int posX, int posY, boolean movement, String image) {

		super(player, posX, posY, movement, image);
		this.p = player;
		this.setP(player);
		super.updateDrawPos();

		if (player == Player.PLAYER1) {
			super.setDrawPosX(super.getDrawPosX() + 20);
			super.setDrawPosY(super.getDrawPosY() + 20);
			super.setImage(BULLET_SPRITE);
		} else {
			super.setDrawPosX(super.getDrawPosX() - 20);
			super.setDrawPosY(super.getDrawPosY() + 20);
			super.setImage(BULLET_SPRITE1);
		}

		startP = super.getDrawPosX();

	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	@Override
	public void move(int[][] gameBoard) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collision(ArrayList<GameElement> characters) {
		// TODO Auto-generated method stub

		new Thread(

				() -> {

					if (p == Player.PLAYER1) {

						while (true) {

							super.setDrawPosX(super.getDrawPosX() + 10);
							
							for(int i= 0; i<characters.size();i++) {
								if(characters.get(i).getImage().equals(Walker.ALIEN_WALKER_SPRITE_1)||characters.get(i).getImage().equals(Walker.ALIEN_WALKER_SPRITE_2)||characters.get(i).getImage().equals(Walker.ALIEN_WALKER_SPRITE_3)) {
									
									double dist = Math.sqrt( ( (super.getDrawPosX()-characters.get(i).getDrawPosX()) * (super.getDrawPosX()-characters.get(i).getDrawPosX())) + ( ( super.getDrawPosY()-characters.get(i).getDrawPosY())*(super.getDrawPosY()-characters.get(i).getDrawPosY())));
									if(dist<60) {
										characters.remove(i);
										super.setDrawPosX(startP);
									}
								
								}
								
							}

							try {
								Thread.sleep(80);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							if (super.getDrawPosX() > 920) {

								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								super.setDrawPosX(startP);
							}

						}

					} else {
						
						while (true) {

							super.setDrawPosX(super.getDrawPosX() - 10);
							
							for(int i= 0; i<characters.size();i++) {
								if(characters.get(i).getImage().equals(Walker.HUMAN_WALKER_SPRITE_1)||characters.get(i).getImage().equals(Walker.HUMAN_WALKER_SPRITE_2)||characters.get(i).getImage().equals(Walker.HUMAN_WALKER_SPRITE_3)) {
									
									double dist = Math.sqrt( ( (super.getDrawPosX()-characters.get(i).getDrawPosX()) * (super.getDrawPosX()-characters.get(i).getDrawPosX())) + ( ( super.getDrawPosY()-characters.get(i).getDrawPosY())*(super.getDrawPosY()-characters.get(i).getDrawPosY())));
									if(dist<60) {
										characters.remove(i);
										super.setDrawPosX(startP);
									}
								
								}
								
							}

							try {
								Thread.sleep(80);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							if (super.getDrawPosX() < 227) {

								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								super.setDrawPosX(startP);
							}

						}
					}

				}

		).start();
	}

	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

}
