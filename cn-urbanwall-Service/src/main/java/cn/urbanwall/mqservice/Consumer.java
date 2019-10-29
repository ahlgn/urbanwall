package cn.urbanwall.mqservice;

import cn.urbanwall.model.TbWaller;
import cn.urbanwall.serviceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;


@Component
public class Consumer {
    @Autowired
    private WallServiceImpl wallService;
    @JmsListener(destination = "wallMessage")
    public void saveWallmessage(Message message) throws JMSException {
        ObjectMessage objectMessage=(ObjectMessage)message;
        if(null!=objectMessage){
            TbWaller waller = (TbWaller) objectMessage.getObject();
            boolean b = wallService.sendWall(waller);
            System.out.println(b?"保存成功":"保存失败");
        }

    }
}
