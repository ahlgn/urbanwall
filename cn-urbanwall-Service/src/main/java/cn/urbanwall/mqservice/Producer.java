package cn.urbanwall.mqservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

}
