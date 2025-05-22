package de.dlh.lhind.order.api.mapper;

import de.dlh.lhind.order.api.model.OrderDto;
import de.dlh.lhind.order.persistence.model.Order;
import de.dlh.lhind.order.persistence.model.OrderProduct;

import java.util.stream.Collectors;

public class OrderMapper {
    public static Order toOrder(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.id());
        order.setUserId(dto.userId());
        order.setStatus(dto.status());
        order.setCreationDate(dto.createdAt());
        order.setLastUpdateDate(dto.updatedAt());
        order.setOrderProduct(dto.productList().stream()
                .map(productId -> {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(productId);
                    orderProduct.setProductId(dto.id());
                    return orderProduct;
                })
                .collect(Collectors.toSet()));
        return order;
    }

    public static OrderDto toOrderDto(Order order) {
        return new OrderDto.Builder()
                .id(order.getId())
                .userId(order.getUserId())
                .status(order.getStatus())
                .createdAt(order.getCreationDate())
                .updatedAt(order.getLastUpdateDate())
                .productList(order.getOrderProduct().stream()
                        .map(OrderProduct::getId)
                        .collect(Collectors.toSet()))
                .build();
    }
}
