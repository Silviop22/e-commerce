package de.dlh.lhind.order.service;

import de.dlh.lhind.order.api.mapper.OrderMapper;
import de.dlh.lhind.order.api.model.OrderDto;
import de.dlh.lhind.order.infrastructure.jms.producer.OrderMessageProducer;
import de.dlh.lhind.order.infrastructure.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMessageProducer orderPublisher;

    public OrderService(final OrderRepository orderRepository,
                        final OrderMessageProducer orderPublisher) {
        this.orderRepository = orderRepository;
        this.orderPublisher = orderPublisher;
    }

    public Long createOrder(OrderDto orderDto) {
        final Long storedOrder = orderRepository.save(OrderMapper.toOrder(orderDto)).getId();
        orderPublisher.publishOrder(orderDto);

        return storedOrder;
    }

}
