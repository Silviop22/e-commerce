package de.dlh.lhind.product.domain.service;

import de.dlh.lhind.product.domain.api.mapper.ProductMapper;
import de.dlh.lhind.product.domain.api.model.ProductDto;
import de.dlh.lhind.product.domain.persistence.criteria.ProductFilterCriteria;
import de.dlh.lhind.product.domain.persistence.model.Product;
import de.dlh.lhind.product.domain.persistence.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductDto> getList(int page, int size, Map<String, Object> filter) {
        Specification<Product> specification = ProductFilterCriteria.build(filter);
        return productRepository.findAll(specification, PageRequest.of(page, size))
                .map(ProductMapper::toDto);
    }
}
