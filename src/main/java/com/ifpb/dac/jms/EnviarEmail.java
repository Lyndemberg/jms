package com.ifpb.dac.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Queue;

/**
 * @author lyndemberg
 */

@JMSDestinationDefinition(name = "java:global/jms/Fila",
                          interfaceName = "javax.jms.Queue",
                          resourceAdapter = "jmsra")
@Stateless
public class EnviarEmail {
    
    @Inject
    private JMSContext context;
    @Resource(lookup = "java:global/jms/Fila")
    private Queue fila;
        
    public void enviar(String email){
        JMSProducer produtor = context.createProducer();
        produtor.send(fila, email);
        System.out.println("Email enviado: " + email);
    }
    
}
