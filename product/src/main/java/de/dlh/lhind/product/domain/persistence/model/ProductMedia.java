package de.dlh.lhind.product.domain.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_media")
public class ProductMedia {
    @Id
    private String mediaUrl;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MediaType type;
    @ManyToOne
    private Product product;

    public String getMediaUrl() {
        return mediaUrl;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
