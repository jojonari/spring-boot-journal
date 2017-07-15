package com.fast87.journal.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jojonari on 2017. 7. 15..
 */
@Component
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    public void messageHandler(String message){
        log.info("소비기 >>"  + message);
    }
}
