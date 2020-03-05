package server;
/**
 *
 * @author JGUTIERRGARC
 */

import java.net.*;
import java.io.*;


public class TCPServer {
    
    public static void main (String args[]) {
	try{
            int serverPort = 7896; 
            ServerSocket listenSocket = new ServerSocket(serverPort);
            AddressBook addressBook = new AddressBook();
            while(true) {
                System.out.println("Waiting for messages..."); 
                Socket clientSocket = listenSocket.accept();  // Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made. 
                Connection c = new Connection(clientSocket, addressBook);
                c.start();
            }
	} catch(IOException e) {
            System.out.println("Listen: " + e.getMessage());
        }
    }
}