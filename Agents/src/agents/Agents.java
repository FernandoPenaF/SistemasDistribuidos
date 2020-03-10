/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Agents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ControllerException {
        try {
            jade.core.Runtime mainRuntime;
            mainRuntime = jade.core.Runtime.instance();
            jade.core.ProfileImpl mainProfile;
            mainProfile = new jade.core.ProfileImpl("localhost", 2000, "AgentPlatform", true);
            mainProfile.setParameter("jade _core_messaging_MessageManager_maxqueuesize", "90000000");
            jade.wrapper.AgentContainer myMainContainer;
            myMainContainer = mainRuntime.createMainContainer(mainProfile);
            
            Object [] agentParams = new Object [6];
            agentParams[0]= "Param 0";
            agentParams[1]= "Param 1";
            agentParams[2]= "Param 2";
            agentParams[3]= "Param 3";
            agentParams[4]= "Param 4";
            agentParams[5]= "Param 5"; 
            
            myMainContainer.createNewAgent("MyMainHelloWorldAgentA","agents.HelloAgent", agentParams); 
            myMainContainer.getAgent("MyMainHelloWorldAgentA").start();
            
            myMainContainer.createNewAgent("MyMainHelloWorldAgentB","agents.HelloAgent", agentParams); 
            myMainContainer.getAgent("MyMainHelloWorldAgentB").start();
            
            myMainContainer.createNewAgent("sniffer","jade.tools.sniffer.Sniffer", null);
            myMainContainer.getAgent("sniffer").start();
            
            myMainContainer.createNewAgent("RMA","jade.tools.rma.rma", null);
            myMainContainer.getAgent("RMA").start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Agents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
