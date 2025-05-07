package de.dlh.lhind.order.api.controller;

import de.dlh.lhind.order.api.model.OrderDto;
import de.dlh.lhind.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
        Long orderId = orderService.createOrder(orderDto);
        return ResponseEntity.created(URI.create("/orders/" + orderId)).build();
    }
}
