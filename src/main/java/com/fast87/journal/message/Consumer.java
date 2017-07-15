package com.fast87.journal.message;

import org.slf4j.*;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by jojonari on 2017. 7. 15..
 */
public class Consumer implements MessageListener{
    private Logger log = LoggerFactory.getLogger(Consumer.class);

    @Override
    public void onMessage(Message message) {
        try {
            log.info("# 소비기 > " + message.getBody(Object.class));
        }catch (JMSException ex){
            ex.printStackTrace();
        }
    }
}
