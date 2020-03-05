/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Lanzador {
    
    public static void main(String[] args) {
        int numClientes = 400;
        int numMsg = 1000;
        ClienteConc[] clientes = new ClienteConc[numClientes];
        ClienteConc c;
        long media;
        long std;
        long sum = 0;
        long sumC  =0;
        int key, min = 0, max = 4;
        
        
        for(int i = 0; i < numClientes; i++){
            key = (int)(Math.random() * ((max - min) + 1)) + min;
            c = new ClienteConc(numMsg,key);
            clientes[i] = c;
            c.start();
        }
        
        for (ClienteConc cn : clientes) {
            try {
                cn.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        for(ClienteConc cl : clientes){
            //System.out.println(cl.idClient);
            
            for(long d : cl.tiempos){
                //System.out.println(d + " de cliente: "+cl.idClient);
                sum += d;
                sumC += Math.pow(d, 2);
                
            }

            
        
        }
        long n = numClientes*numMsg;
        media = sum / n;
        double aux = (sumC-n*Math.pow(media, 2))/(n-1);
        std = (long) Math.sqrt(aux);
        System.out.println("Media : "+media);
        System.out.println("Desviacion : "+ std);
        
            
    }
    
}
