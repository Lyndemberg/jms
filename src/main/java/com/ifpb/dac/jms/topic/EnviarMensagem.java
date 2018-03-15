package com.ifpb.dac.jms.topic;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Topic;

/**
 * @author lyndemberg
 */
@JMSDestinationDefinition(
        name = "java:global/jms/Topic",
        interfaceName = "javax.jms.Topic",
        resourceAdapter = "jmsra",
        destinationName = "topico"
)
@Stateless
public class EnviarMensagem {
    @Resource(lookup = "java:global/jms/Topic")
    private Topic topico;
    @Inject
    private JMSContext context;
    
    public void enviar(String setor, String mensagem){
        JMSProducer produtor = context.createProducer();
        produtor.setProperty("setor", setor);
        produtor.send(topico, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }
}
