/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.net.*;
import java.io.*;

public class ClientThread extends Thread{
    int numMensajes = 1;
    int key;
    
    public ClientThread(){
    }
    
    public ClientThread(int numMensajes, int key){
        this.numMensajes = numMensajes;
        this.key = key;
    }
    
    @Override
    public void run(){
        Socket s = null;
        try {
            long startTime, spentTime;
            int serverPort = 7896;
            s = new Socket("localhost", serverPort);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            for (int i = 0; i < this.numMensajes; i++) {
                startTime = System.currentTimeMillis();
                out.writeUTF(String.valueOf(key)); // UTF is a string encoding
                String data = in.readUTF();
                spentTime = System.currentTimeMillis() - startTime;
                System.out.println("Received: " + data);
            }
            out.writeUTF("-1");
            
        } catch (UnknownHostException e) {
            System.out.println("Sock:" + e.getMessage()); 
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } finally {
            if(s != null){
                try {
                    s.close();
                } catch(IOException e){
                    System.out.println("close:" + e.getMessage());
                }
            }
        }
    }
}
