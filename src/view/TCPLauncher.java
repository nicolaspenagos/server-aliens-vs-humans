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
import tcpmodel.PlayerNumber;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

import com.google.gson.Gson;

/*
 * In this class you will find the TCP sockets Launcher using Singleton and Observer patterns.
 */
public class TCPLauncher extends Thread{

	
	// -------------------------------------
    // Global variables
    // -------------------------------------
	private static TCPLauncher instance; //Unique Instance 
	private OnMessageListener observer;
	private ServerSocket serverSocket;
	private Session session1;
	private Session session2;
	private boolean killThread;
	private Gson gson;
	
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
			gson = new Gson();
			
			while(!killThread) {
				
				Socket socket = serverSocket.accept();
				Session session;
				
				if(session1 == null) {
					
					PlayerNumber playerNumber = new PlayerNumber(UUID.randomUUID().toString(), 0, "The player number");
					session = new Session(socket, 1, playerNumber);
					session1 = session;
					session.setObserver(observer);
					session.start();
					
					String json = gson.toJson(playerNumber);
					session.sendMessage(json);
					
				}else if(session2 == null) {
					
					PlayerNumber playerNumber = new PlayerNumber(UUID.randomUUID().toString(), 1, "The player number");
					
					session = new Session(socket, 2, playerNumber);
					session2 = session;
					session.setObserver(observer);
					session.start();
					
					String json = gson.toJson(playerNumber);
					session.sendMessage(json);
					
				}
				
				
			
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
