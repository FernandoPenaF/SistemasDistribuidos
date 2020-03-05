/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            HelloThread hilo1 = new HelloThread();
            Thread hilo2 = new Thread(new HelloRunnable());
            
            System.out.println(Thread.currentThread().getName());
            hilo1.start();
            hilo1.join();
            System.out.println("Hilo principal!");
            hilo2.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
