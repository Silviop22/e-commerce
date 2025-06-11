package de.dlh.lhind.fulfillment.infrastructure.listener;

import jakarta.jms.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventListener.class);

    @JmsListener(destination = "${fulfillment.application.jms.receive.order.topic}")
    public void receiveOrder(final Message message) {
        LOGGER.info("Received order message: {}", message);
    }
}
