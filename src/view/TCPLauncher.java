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

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * In this class you will find the TCP sockets Launcher using Singleton and Observer patterns.
 */
public class TCPLauncher extends Thread{

	
	// -------------------------------------
    // Global variables
    // -------------------------------------
	public static TCPLauncher instance; //Unique Instance 
	private OnMessageListener observer;
	private ServerSocket serverSocket;
	private Session session1;
	private Session session2;
	private boolean killThread;
	
	// -------------------------------------
    // Constructor 
    // -------------------------------------
	private TCPLauncher() {
		
	}
	
	// -------------------------------------
    // Singleton pattern
    // -------------------------------------
	public static TCPLauncher getInstance() {
		
		if(instance == null) {
			instance = new TCPLauncher();
		}
		return instance;
		
	}

	// -------------------------------------
    // TCP
    // -------------------------------------
	public void run() {
		
		try {
			
			killThread = false;
			serverSocket = new ServerSocket(5000);
			
			while(!killThread) {
				
				Socket socket = serverSocket.accept();
				
				Session session = new Session(socket);
				session.setObserver(observer);
				session.start();
				
				if(session1 == null)
					session1 = session;
				else if(session2 == null) 
					session2 = session;
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// -------------------------------------
    // Getters and setters
    // -------------------------------------
	public OnMessageListener getObserver() {
		return observer;
	}

	public void setObserver(OnMessageListener observer) {
		this.observer = observer;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public Session getSession1() {
		return session1;
	}

	public void setSession1(Session session1) {
		this.session1 = session1;
	}

	public Session getSession2() {
		return session2;
	}

	public void setSession2(Session session2) {
		this.session2 = session2;
	}
	
	public boolean getKillThread() {
		return killThread;
	}
	
	public void setKillThread(boolean killThread) {
		this.killThread = killThread;
	}
		
}
