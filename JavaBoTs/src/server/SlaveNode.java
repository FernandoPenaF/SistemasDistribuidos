/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.BioInformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class SlaveNode implements BioInformatics, DataMining, ImageProcessing{

    public SlaveNode() throws RemoteException{
        super();
    }
    
    public void despliege(String name){
        try {
            SlaveNode engine = new SlaveNode();
            
            switch (name) {
                case "BioInformatics":
                    {
                        BioInformatics stub = (BioInformatics) UnicastRemoteObject.exportObject(engine, 0);
                        Registry registry = LocateRegistry.getRegistry();
                        registry.rebind(name, stub);
                        break;
                    }
                case "DataMining":
                    {
                        DataMining stub = (DataMining) UnicastRemoteObject.exportObject(engine, 0);
                        Registry registry = LocateRegistry.getRegistry();
                        registry.rebind(name, stub);
                        break;
                    }
                default:
                    {
                        ImageProcessing stub = (ImageProcessing) UnicastRemoteObject.exportObject(engine, 0);
                        Registry registry = LocateRegistry.getRegistry();
                        registry.rebind(name, stub);
                        break;
                    }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void executeBioTask(Task aTask) throws RemoteException {
        try {
            Thread.sleep(aTask.getLength());
            System.out.println("Bio task executed");
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void executeDataTask(Task aTask) throws RemoteException {
        try {
            Thread.sleep(aTask.getLength());
            System.out.println("Data task executed");
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void executeImageTask(Task aTask) throws RemoteException {
        try {
            Thread.sleep(aTask.getLength());
            System.out.println("Image task executed");
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
