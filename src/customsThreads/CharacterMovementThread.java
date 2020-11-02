/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package customsThreads;

import view.AliensVsHumans;

/*
 * This class is used to movements all game elements on the screen.
 */
public class CharacterMovementThread extends Thread{
	
	// -------------------------------------
	// Attributes
	// -------------------------------------
	private AliensVsHumans aliensVsHumans;
	private boolean killThread;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public CharacterMovementThread() {
		
	}
	
	// -------------------------------------
	// Thread
	// -------------------------------------
	public void run() {
		
		setKillThread(false);
		while(!isKillThread()) {
			
			try {
				
				getAliensVsHumans().moveGameElements();
				Thread.sleep(300);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public AliensVsHumans getAliensVsHumans() {
		return aliensVsHumans;
	}

	public void setAliensVsHumans(AliensVsHumans aliensVsHumans) {
		this.aliensVsHumans = aliensVsHumans;
	}

	public boolean isKillThread() {
		return killThread;
	}

	public void setKillThread(boolean killThread) {
		this.killThread = killThread;
	}
	
}
