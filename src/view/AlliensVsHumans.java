/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package view;

import events.OnMessageListener;
import processing.core.PApplet;

/*
 * This is the main class, here is the implementation of the proccesing technology as a tool for drawing the video game
 */
public class AlliensVsHumans extends PApplet implements OnMessageListener {

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private TCPLauncher tcp;

	// -------------------------------------
	// Main method
	// -------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.AlliensVsHumans");
	}

	// -------------------------------------
	// Processing methods
	// -------------------------------------
	public void settings() {
		size(1200, 700);
	}

	public void setup() {

		tcp = TCPLauncher.getInstance();
		tcp.setObserver(this);
		tcp.start();

	}

	public void draw() {

	}

	// -------------------------------------
	// TCP
	// -------------------------------------
	@Override
	public void OnMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		tcp.getSession1().sendMessage("Hi back");
	}

}
