package de.dlh.lhind.order.infrastructure.jms.publisher;

import de.dlh.lhind.order.api.model.OrderDto;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {

    private final JmsTemplate jmsTemplate;

    public OrderEventPublisher(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void publishOrder(final OrderDto order) {
        jmsTemplate.convertAndSend(order);
    }
}
