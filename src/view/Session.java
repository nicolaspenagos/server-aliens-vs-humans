/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolas Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * 
 * @author Valentina Zapata Zapata
 * valzapataz@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.UUID;

import com.google.gson.Gson;

import events.OnMessageListener;
import tcpmodel.PlayerNumber;

/*
 * This class represents a player's session,one for each player.
 */
public class Session extends Thread{

	// -------------------------------------
	// Attributes
	// -------------------------------------
	private String ID;
	private BufferedWriter writer;
	private Socket socket;
	private OnMessageListener observer;
	private PlayerNumber playerNumber;
	private boolean killThread;
	private int sessionNumber;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Session(Socket socket, int sessionNumber, PlayerNumber playerNumber) {

		this.socket = socket;
		this.ID = UUID.randomUUID().toString();
		this.setSessionNumber(sessionNumber);
		this.playerNumber = playerNumber;
		
	}
	
	// -------------------------------------
    // TCP
    // -------------------------------------
	public void run() {
		
		try {
			
			killThread = false;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Gson gson = new Gson();
			
			if(sessionNumber == 1) {
				observer.OnMessageP1(gson.toJson(playerNumber));
			}else if(sessionNumber == 2) {
				observer.OnMessageP2(gson.toJson(playerNumber));
			}
			
			
			while(!killThread) {
				
				String msg = reader.readLine();
				if(sessionNumber == 1)
					observer.OnMessageP1(msg);
				else if(sessionNumber == 2)
					observer.OnMessageP2(msg);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void sendMessage(String msg){

        new Thread(

                ()->{
                    
                    try {

                        writer.write(msg+"\n");
                        writer.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                }

        ).start();

    }
	
	// -------------------------------------
	// Getters and setters
	// -------------------------------------
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public BufferedWriter getWriter() {
		return writer;
	}

	public void setWriter(BufferedWriter writer) {
		this.writer = writer;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public OnMessageListener getObserver() {
		return observer;
	}

	public void setObserver(OnMessageListener observer) {
		this.observer = observer;
	}

	public boolean isKillThread() {
		return killThread;
	}

	public void setKillThread(boolean killThread) {
		this.killThread = killThread;
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public PlayerNumber getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(PlayerNumber playerNumber) {
		this.playerNumber = playerNumber;
	}

}
