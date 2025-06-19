package de.dlh.lhind.order.infrastructure.jms.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.dlh.lhind.order.api.model.OrderDto;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageProducer {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    public OrderMessageProducer(final JmsTemplate jmsTemplate, final ObjectMapper objectMapper) {
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
    }

    public void publishOrder(final OrderDto order) {
        try {
            jmsTemplate.convertAndSend(objectMapper.writeValueAsString(order));
        } catch (final JsonProcessingException e) {
            // Do nothing
        }
    }
}
