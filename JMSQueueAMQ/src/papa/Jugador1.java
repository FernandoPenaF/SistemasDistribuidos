/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package papa;

/**
 *
 * @author LPENAF
 */
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Jugador1 {

    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the queue we will receive messages from
    private static String myQueue = "PAPAJ1_QUEUE";
    private static String otherQueue = "PAPAJ2_QUEUE";
    
    public void getMessages() {
        boolean goodByeReceived = false;
        Papa papa = new Papa(1);
        
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connectionFactory.setTrustAllPackages(true);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            
            Destination destinationProducer, destinationConsumer;
            MessageProducer messageProducer;
            MessageConsumer messageConsumer;
            ObjectMessage objectMessage;
            Session session;
            
            session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            
            //Setup sender of otherQueue
            destinationProducer = session.createQueue(otherQueue);
            messageProducer = session.createProducer(destinationProducer);
            
            //Setup listener of myQueue
            destinationConsumer = session.createQueue(myQueue);
            messageConsumer = session.createConsumer(destinationConsumer);
            
            //Send papa
            objectMessage = session.createObjectMessage();
            objectMessage.setObject(papa);
            System.out.println("Sending the following message: " + objectMessage.getObject());
            messageProducer.send(objectMessage);
            
            while (!goodByeReceived) {
                System.out.println("Waiting for messages...");
                objectMessage = (ObjectMessage) messageConsumer.receive();
                if (objectMessage != null) {
                    papa = (Papa) objectMessage.getObject();
                    System.out.print("Received the following message: ");
                    System.out.println(papa);
                    System.out.println();
                    
                    if(papa.getTtl() == 0){
                        System.out.println("Perdiste!");
                        goodByeReceived = true;
                    } else {
                        papa.decrementTtl();
                        objectMessage = session.createObjectMessage();
                        objectMessage.setObject(papa);
                        System.out.println("Sending the following message: " + objectMessage.getObject());
                        messageProducer.send(objectMessage);
                    }
                }
            }
            
            messageConsumer.close();
            messageProducer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Jugador1().getMessages();
    }
}