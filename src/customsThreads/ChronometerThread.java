/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package customsThreads;

import model.Chronometer;

/*
 * This class is used to take time during the game.
 */
public class ChronometerThread extends Thread {

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private Chronometer c;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public ChronometerThread(Chronometer c) {
		this.c = c;
	}

	// -------------------------------------
	// Run
	// -------------------------------------
	@Override
	public void run() {
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 60; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					if (j > 50)
						c.changeTime((2-i) + ":0" + (59-j) + ":" + (100-j2));
					else
						c.changeTime((2-i) + ":" + (59-j) + ":" + (100-j2));
					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		c.setFinished(true);
	}
	
}