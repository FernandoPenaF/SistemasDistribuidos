/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Financial;

/**
 *
 * @author JGUTIERRGARC
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "";
    private static String topics[] = {"EDUCATION_TOPIC", "TRANSPORTATION_TOPIC",
                                    "FOODSUPPLY_TOPIC", "BANKS_TOPIC",
                                    "TELECOMMUNICATIONS_TOPIC"};
    
    public void getMessages() {
        boolean goodByeReceived = false;
        String received, subject = topics[1];
        int priority;

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic(subject);

            MessageConsumer messageConsumer = session.createConsumer(destination);
            
            System.out.println("I'm a floor broker handling " + subject);
            while (!goodByeReceived) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                received = textMessage.getText();
                if (textMessage != null) {
                    if(received.equals("FIN_NOTICIAS")){
                        goodByeReceived = true;
                    } else {
                        priority = Integer.valueOf(received);
                        System.out.println("I've received bad news of level: " + received);
                        
                        if(priority > 5) {
                            System.out.println("Selling! Selling! Selling!");
                        } else {
                            System.out.println("I have to be patient. There is "
                                    + "no such thing as a 'global economic crisis'");
                        }
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
        new MessageReceiver().getMessages();
    }
}
