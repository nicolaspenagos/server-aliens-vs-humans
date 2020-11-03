/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import customsThreads.ChronometerThread;

/*
 * This class is used to movements all game elements on the screen.
 */
public class Chronometer {

	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private int min;
	private int sec;
	private String time;
	private boolean finished;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Chronometer() {

		int min = 0;
		int sec = 0;
		time = "";
		ChronometerThread cT = new ChronometerThread(this);
		cT.setDaemon(true);
		cT.start();

	}

	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public void changeTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}