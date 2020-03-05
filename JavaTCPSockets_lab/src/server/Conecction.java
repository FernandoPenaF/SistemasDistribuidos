/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

class Connection extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    AddressBook addressBook;
    
    public Connection (Socket aClientSocket) {
            try {
                clientSocket = aClientSocket;
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            }catch(IOException e){
                System.out.println("Connection:" + e.getMessage());
            }
    }

    public Connection (Socket aClientSocket, AddressBook addressBook) {
        try {
            this.addressBook = addressBook;
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
        }catch(IOException e){
            System.out.println("Connection:" + e.getMessage());
        }
    }

    @Override
    public void run(){
        boolean band = true;
        while(band){
            try {
                String data = in.readUTF();
                
                if(data.compareTo("-1") == 0){
                    try {
                    clientSocket.close();
                    } catch (IOException e){
                        System.out.println(e);
                    }
                    band = false;
                    continue;
                }
                
                System.out.println("Message -> " + data + " <- received from: " + clientSocket.getRemoteSocketAddress());

                int id = Integer.parseInt(data);
                String nombre = addressBook.getRecord(id).getName();

                if(nombre.compareTo("") == 0){
                    out.writeUTF("No se encontró en el servidor ese cliente");
                }else{ 
                    out.writeUTF(nombre);
                }
            } catch(EOFException e) {
                System.out.println("EOF:" + e.getMessage());
            } catch(IOException e) {
                System.out.println("IO:" + e.getMessage());
            }
        }
    }
}
