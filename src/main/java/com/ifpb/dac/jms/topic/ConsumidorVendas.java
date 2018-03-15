package com.ifpb.dac.jms.topic;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author lyndemberg
 */
@MessageDriven(
        mappedName = "java:global/jms/Topic",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
            @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "topico"),
            @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "setor='vendas'"),
        }
)
public class ConsumidorVendas implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            String body = message.getBody(String.class);
            System.out.println("Recebida pelo setor de vendas: " + body);
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
