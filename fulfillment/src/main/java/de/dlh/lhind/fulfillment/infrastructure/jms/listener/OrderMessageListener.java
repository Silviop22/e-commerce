package de.dlh.lhind.fulfillment.infrastructure.jms.listener;

import jakarta.jms.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMessageListener.class);

    @JmsListener(destination = "${fulfillment.application.jms.listener.order.topic}")
    public void onMessage(final Message message) {
        LOGGER.info(message.toString());
        throw new RuntimeException("Will never be acknowledged");
    }
}
