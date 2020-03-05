/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

import java.net.*;
import java.io.*;

public class TCPClient {

    public static void main (String args[]) {

	Socket s = null;
	    try {
	    	int serverPort = 7896;
	   	
                s = new Socket("localhost", serverPort);    
             //   s = new Socket("127.0.0.1", serverPort);    
		DataInputStream in = new DataInputStream( s.getInputStream());
		DataOutputStream out =
			new DataOutputStream( s.getOutputStream());
		out.writeUTF("Hello");// UTF is a string encoding //se puede comportar como bloqueante, muy pequeñito lo que se espera. En terminos pragmaticos es no bloqueante, aunque en teoria sí.
                
		String data = in.readUTF();	      
                System.out.println("Received: "+ data) ;      
       	    } 
            catch (UnknownHostException e) {
		System.out.println("Sock:"+e.getMessage()); 
	    }
            catch (EOFException e) {
                System.out.println("EOF:"+e.getMessage());
    	    } 
            catch (IOException e) {
                System.out.println("IO:"+e.getMessage());
            } finally {
                if(s!=null) 
                    try {
                        s.close();//cerramos el socket y liberamos el registro
                    } catch (IOException e){
                    System.out.println("close:"+e.getMessage());}
                    }
            }
}
