/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author sdist
 */
public class HilosSync {
    public static void main(String[] args) {
        Counter counter = new Counter(0);
        SynchronizedThread hiloContador1 = new SynchronizedThread(counter);
        SynchronizedThread hiloContador2 = new SynchronizedThread(counter);
        hiloContador1.start();
        hiloContador2.start();
    }
}
