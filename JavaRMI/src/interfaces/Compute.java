/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote; 
import java.rmi.RemoteException;

/**
 *
 * @author sdist
 */
public interface Compute extends Remote{
    public double square(int number, Credential person) throws RemoteException;
    public double power (int num1, int num2, Credential person) throws RemoteException;
}
