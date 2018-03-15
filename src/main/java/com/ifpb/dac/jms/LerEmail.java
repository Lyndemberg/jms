package com.ifpb.dac.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 * @author lyndemberg
 */

@Stateless
public class LerEmail {
    @Inject
    private JMSContext context;
    @Resource(lookup = "java:global/jms/Fila")
    private Queue fila;
    
    public String ler(){
        JMSConsumer consumidor = context.createConsumer(fila);
        TextMessage receive = (TextMessage) consumidor.receive();
        try {
            return fila.getQueueName() + receive.getText();
        } catch (JMSException ex) {
            Logger.getLogger(LerEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "sem email";
    }
}
