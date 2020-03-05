/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.BioInformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class MasterNode extends Thread{
    private static Task[] imageTasks = {new Task("T1", "ImageProcessing", 5000), 
                                    new Task("T2", "ImageProcessing", 10000),
                                    new Task("T3", "ImageProcessing", 15000),
                                    new Task("T4", "ImageProcessing", 20000),
                                    new Task("T5", "ImageProcessing", 30000),
                                    new Task("T6", "ImageProcessing", 5000),
                                    new Task("T7", "ImageProcessing", 10000),
                                    new Task("T8", "ImageProcessing", 15000),
                                    new Task("T9", "ImageProcessing", 20000),
                                    new Task("T10", "ImageProcessing", 30000)};
    
    private static Task[] dataTasks = {new Task("T11", "DataMining", 5000), 
                                    new Task("T12", "DataMining", 10000),
                                    new Task("T13", "DataMining", 15000),
                                    new Task("T14", "DataMining", 20000),
                                    new Task("T15", "DataMining", 30000),
                                    new Task("T16", "DataMining", 5000),
                                    new Task("T17", "DataMining", 10000),
                                    new Task("T18", "DataMining", 15000),
                                    new Task("T19", "DataMining", 20000),
                                    new Task("T20", "DataMining", 30000),
                                    new Task("T21", "DataMining", 5000), 
                                    new Task("T22", "DataMining", 10000),
                                    new Task("T23", "DataMining", 15000),
                                    new Task("T24", "DataMining", 20000),
                                    new Task("T25", "DataMining", 30000),
                                    new Task("T26", "DataMining", 5000),
                                    new Task("T27", "DataMining", 10000),
                                    new Task("T28", "DataMining", 15000),
                                    new Task("T29", "DataMining", 20000),
                                    new Task("T30", "DataMining", 30000)};
    
    private static Task[] bioTasks = {new Task("T31", "BioInformatics", 5000), 
                                    new Task("T32", "BioInformatics", 10000),
                                    new Task("T33", "BioInformatics", 15000),
                                    new Task("T34", "BioInformatics", 20000),
                                    new Task("T35", "BioInformatics", 30000),
                                    new Task("T36", "BioInformatics", 5000),
                                    new Task("T37", "BioInformatics", 10000),
                                    new Task("T38", "BioInformatics", 15000),
                                    new Task("T39", "BioInformatics", 20000),
                                    new Task("T40", "BioInformatics", 30000),
                                    new Task("T41", "BioInformatics", 5000), 
                                    new Task("T42", "BioInformatics", 10000),
                                    new Task("T43", "BioInformatics", 15000),
                                    new Task("T44", "BioInformatics", 20000),
                                    new Task("T45", "BioInformatics", 30000)};
    
    public static void main(String[] args) throws NotBoundException {
        System.setProperty("java.security.policy","file:/C:/Users/sdist.ITAM/Desktop/LFPFSD/JavaBoTs/src/client/client.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Registry registry = LocateRegistry.getRegistry("localhost"); // server's ip address Computecomp = (Compute) registry.lookup(name);
            TaskThread t1 = new TaskThread(bioTasks, registry);
            t1.start();
            TaskThread t2 = new TaskThread(dataTasks, registry);
            t2.start();
            TaskThread t3 = new TaskThread(imageTasks, registry);
            t3.start();
        } catch (RemoteException ex){
            System.out.println(ex.toString());
        }
    }
}

class TaskThread extends Thread {
    private Task[] task;
    private Registry registry;

    public TaskThread(Task[] task, Registry registry) {
        this.task = task;
        this.registry = registry;
    }
    
    @Override
    public void run(){
        try {
            BioInformatics bio = null;
            DataMining data = null;
            ImageProcessing image = null;
            String name = task[0].getRequirementId();
            
            switch (name) {
                case "BioInformatics":
                    bio = (BioInformatics) registry.lookup(name);
                    break;
                case "DataMining":
                    data = (DataMining) registry.lookup(name);
                    break;
                default:
                    image = (ImageProcessing) registry.lookup(name);
                    break;
            }
            
            for (Task tasks : task) {
                switch (name) {
                    case "BioInformatics":
                        bio.executeBioTask(tasks);
                        break;
                    case "DataMining":
                        data.executeDataTask(tasks);
                        break;
                    default:
                        image.executeImageTask(tasks);
                        break;
                }
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
