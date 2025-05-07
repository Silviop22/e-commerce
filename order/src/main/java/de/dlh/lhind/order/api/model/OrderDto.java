package de.dlh.lhind.order.api.model;

import de.dlh.lhind.order.persistence.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.Set;

public record OrderDto(Long id, Long userId, OrderStatus status, LocalDateTime createdAt, LocalDateTime updatedAt,
                       Set<Long> productList) {

    public static class Builder {
        private Long id;
        private Long userId;
        private OrderStatus status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Set<Long> productList;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder status(OrderStatus status) {
            this.status = status;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder productList(Set<Long> productList) {
            this.productList = productList;
            return this;
        }

        public OrderDto build() {
            return new OrderDto(id, userId, status, createdAt, updatedAt, productList);
        }
    }
}
