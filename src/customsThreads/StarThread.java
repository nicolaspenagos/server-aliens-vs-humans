/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package customsThreads;

import java.util.concurrent.ThreadLocalRandom;

import view.AliensVsHumans;

/*
 * This class is used to generate random stars that will be sent to users.
 */
public class StarThread extends Thread{
	
	// -------------------------------------
	// Attributes
	// -------------------------------------
	private AliensVsHumans aliensVsHumans;
	private boolean killThread;
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public StarThread(AliensVsHumans serverVsHumans) {
		this.setServerVsHumans(serverVsHumans);
	}
	
	// -------------------------------------
	// Thread
	// -------------------------------------
	public void run() {
		
		killThread = false;
		while(!killThread) {
			
			try {
				
				int time = ThreadLocalRandom.current().nextInt(5, 12 + 1);
				time = time * 1000;
				
				sleep(time);
				aliensVsHumans.launchStar(""+time);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}

	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public AliensVsHumans getServerVsHumans() {
		return aliensVsHumans;
	}

	public void setServerVsHumans(AliensVsHumans serverVsHumans) {
		this.aliensVsHumans = serverVsHumans;
	}

	public boolean isKillThread() {
		return killThread;
	}

	public void setKillThread(boolean killThread) {
		this.killThread = killThread;
	}

}
