/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

public class Launcher {
    
    public static void main(String[] args) {
        int numClientes = 2;
        int numMensajes = 10;
        int key, min = 0, max = 4;
        ClientThread clientThread;
        
        for (int i = 0; i < numClientes; i++) {
            key = (int)(Math.random() * ((max - min) + 1)) + min;
            clientThread = new ClientThread(numMensajes, key);
            
            clientThread.start();
        }
    }
}
