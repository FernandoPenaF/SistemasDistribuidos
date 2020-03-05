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
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

    // A static manner to link jms resources with java objects
    //@Resource(mappedName = "jms/TestConnectionFactory")  
    //private static ConnectionFactory connectionFactory;  
    //@Resource(mappedName = "jms/TestQueue")  
    //private static Queue queue;  
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // default broker URL is : tcp://localhost:61616"
    private static String subject = "PAPA_QUEUE"; // Queue Name. You can create any/many queue names as per your requirement. 
    
    public void produceMessages() {
        MessageProducer messageProducer;
        ObjectMessage objectMessage;
        Papa papa = new Papa(1);
        
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(subject);

            messageProducer = session.createProducer(destination);
            objectMessage = session.createObjectMessage();

            objectMessage.setObject(papa);
            System.out.println("Sending the following message: " + objectMessage.getObject());
            messageProducer.send(objectMessage);

            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSender().produceMessages();
    }
}
