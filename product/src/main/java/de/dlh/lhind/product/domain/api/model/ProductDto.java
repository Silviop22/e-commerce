package de.dlh.lhind.product.domain.api.model;

import de.dlh.lhind.product.domain.persistence.model.MediaType;

import java.math.BigDecimal;
import java.util.List;

public record ProductDto(Long id, String name, String description, List<ProductMedia> mediaList, String category,
                         String subcategory, BigDecimal price, Long stock, boolean deleted) {
    public record ProductMedia(String url, MediaType mediaType) {
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private List<ProductMedia> mediaList;
        private String category;
        private String subcategory;
        private BigDecimal price;
        private Long stock;
        private boolean deleted;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder mediaList(List<ProductMedia> mediaList) {
            this.mediaList = mediaList;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder subcategory(String subcategory) {
            this.subcategory = subcategory;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder stock(Long stock) {
            this.stock = stock;
            return this;
        }

        public Builder deleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public ProductDto build() {
            return new ProductDto(id, name, description, mediaList, category, subcategory, price, stock, deleted);
        }
    }
}
