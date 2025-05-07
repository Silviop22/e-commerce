package de.dlh.lhind.order.service;

import de.dlh.lhind.order.api.mapper.OrderMapper;
import de.dlh.lhind.order.api.model.OrderDto;
import de.dlh.lhind.order.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long createOrder(OrderDto orderDto) {
        return orderRepository.save(OrderMapper.toOrder(orderDto))
                .getId();
    }

}
