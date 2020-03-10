/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
/**
 *
 * @author sdist
 */
public class HelloAgent extends Agent{
    
    @Override
    protected void setup() {
        Object[] params = getArguments();
        
        if(params != null){
            for(Object param: params){
                System.out.println((String) param);
            }
        }
        System.out.println("Hello World. ");
        System.out.println("My name local is " + getLocalName());
        System.out.println("My GUID is " + getAID().getName());
    }
    
    private class MessageListener extends CyclicBehaviour{ 
        private Agent agt; 
        private MessageTemplate mt;
        
        public MessageListener(Agent a, String topicID) { 
            agt=a; 
            mt= MessageTemplate.and(MessageTemplate.MatchConversationId(topicID), 
                    MessageTemplate.MatchPerformative(ACLMessage.INFORM));
        }
        
        @Override
        public void action() {
            ACLMessage msg = agt.receive(mt); 
            if (msg == null) { 
                block(); return; 
            }          
            try { 
                String content = msg.getContent();
                System.out.println("I received a messagefrom " + msg.getSender() + " saying: " + msg.getContent());
            } catch(Exception ex) {
                ex.printStackTrace();
            }      
        }
    }
}
