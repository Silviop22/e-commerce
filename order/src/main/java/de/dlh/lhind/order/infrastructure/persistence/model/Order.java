package de.dlh.lhind.order.infrastructure.persistence.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long id;
    @Column(nullable = false, name = "creation_date")
    private LocalDateTime creationDate;
    @Column(nullable = false, name = "last_update_date")
    private LocalDateTime lastUpdateDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;
    @Column(nullable = false, name = "user_id")
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<OrderProduct> orderProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Set<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }
}
