/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package papa;

/**
 *
 * @author JGUTIERRGARC
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

public class Jugador2 {

    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the queue we will receive messages from
    private static String subject = "PAPAJ2_QUEUE";

    public void getMessages() {
        boolean goodByeReceived = false;
        Papa papa = new Papa(1);
        
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connectionFactory.setTrustAllPackages(true);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            
            MessageProducer messageProducer;
            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(subject);
            MessageConsumer messageConsumer = session.createConsumer(destination);
            ObjectMessage objectMessage;
            
            messageProducer = session.createProducer(destination);
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
                        messageProducer = session.createProducer(destination);
                        objectMessage = session.createObjectMessage();
                        objectMessage.setObject(papa);
                        System.out.println("Sending the following message: " + objectMessage.getObject());
                        messageProducer.send(objectMessage);
                    }
                }
            }
            
            messageConsumer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Jugador2().getMessages();
    }

}
