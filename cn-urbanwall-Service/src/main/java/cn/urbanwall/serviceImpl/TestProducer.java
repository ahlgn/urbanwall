package cn.urbanwall.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Destination;

@Service("Producer")
public class TestProducer {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }
}
