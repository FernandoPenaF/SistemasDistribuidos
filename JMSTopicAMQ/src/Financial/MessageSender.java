/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Financial;

/**
 *
 * @author JGUTIERRGARC
 */
import java.util.Random;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
    private static int numMensajes = 20;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // default broker URL is : tcp://localhost:61616"
    private static String topics[] = {"EDUCATION_TOPIC", "TRANSPORTATION_TOPIC",
                                    "FOODSUPPLY_TOPIC", "BANKS_TOPIC",
                                    "TELECOMMUNICATIONS_TOPIC"};
    private static String subject = "";
    
    public void produceMessages() {
        MessageProducer messageProducer;
        TextMessage textMessage;
        Destination destination;
        Random random = new Random();
        int idTopic;
        Integer priority;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);

            for (int i = 0; i < numMensajes; i++) {
                priority = random.nextInt(10);
                idTopic = random.nextInt(5);
                subject = topics[idTopic];
                
                destination = session.createTopic(subject);
                messageProducer = session.createProducer(destination);
                textMessage = session.createTextMessage();
                
                textMessage.setText(priority.toString());
                System.out.println("Sending terrible market news. Level: " + 
                        textMessage.getText() + " Category: " + subject);
                messageProducer.send(textMessage);
            }
            
            for (int i = 0; i < topics.length; i++) {
                subject = topics[i];
                destination = session.createTopic(subject);
                messageProducer = session.createProducer(destination);
                textMessage = session.createTextMessage();
                
                textMessage.setText("FIN_NOTICIAS");
                messageProducer.send(textMessage);
                messageProducer.close();
                
            }
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
