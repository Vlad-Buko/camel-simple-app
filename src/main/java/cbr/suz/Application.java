package cbr.suz;

import cbr.suz.router.RouteCamel;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

/**
 * Created by Vladislav Domaniewski
 */

public class Application {
    public static void main(String[] args) {
        RouteCamel routeCamel = new RouteCamel();
        CamelContext context = new DefaultCamelContext();

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        try {
            context.addRoutes(routeCamel);
            context.start();
            Thread.sleep(5 * 60 * 1000);
            context.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
