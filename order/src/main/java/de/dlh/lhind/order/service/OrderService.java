package de.dlh.lhind.order.service;

import de.dlh.lhind.order.api.mapper.OrderMapper;
import de.dlh.lhind.order.api.model.OrderDto;
import de.dlh.lhind.order.infrastructure.jms.publisher.OrderEventPublisher;
import de.dlh.lhind.order.infrastructure.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher orderEventPublisher;

    public OrderService(final OrderRepository orderRepository,
                        final OrderEventPublisher orderEventPublisher) {
        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
    }

    public Long createOrder(OrderDto orderDto) {
        final Long createdOrderId = orderRepository.save(OrderMapper.toOrder(orderDto)).getId();

        orderEventPublisher.publishOrder(orderDto);

        return createdOrderId;
    }

}
