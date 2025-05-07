package de.dlh.lhind.product.domain.api.mapper;

import de.dlh.lhind.product.domain.api.model.ProductDto;
import de.dlh.lhind.product.domain.persistence.model.Category;
import de.dlh.lhind.product.domain.persistence.model.Product;
import de.dlh.lhind.product.domain.persistence.model.SubCategory;

import java.util.List;
import java.util.Optional;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        String subCategory = Optional.of(product)
                .map(Product::getSubCategory)
                .map(SubCategory::getName)
                .orElse(null);
        String category = Optional.of(product)
                .map(Product::getSubCategory)
                .map(SubCategory::getCategory)
                .map(Category::getName)
                .orElse(null);
        List<ProductDto.ProductMedia> media = Optional.of(product)
                .map(Product::getMedia)
                .map(mediaList -> mediaList.stream()
                        .map(m -> new ProductDto.ProductMedia(m.getMediaUrl(), m.getType()))
                        .toList())
                .orElse(null);

        return new ProductDto.Builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(category)
                .subcategory(subCategory)
                .price(product.getPrice())
                .mediaList(media)
                .stock(product.getStock())
                .deleted(product.isDeleted())
                .build();
    }
}
