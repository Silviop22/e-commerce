package de.dlh.lhind.product.domain.persistence.criteria;

import de.dlh.lhind.persistence.criteria.GenericSpecificationBuilder;
import de.dlh.lhind.product.domain.persistence.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class ProductFilterCriteria {
    private static final GenericSpecificationBuilder<Product> BUILDER = new GenericSpecificationBuilder<>();

    public static Specification<Product> build(Map<String, Object> criteria) {
        return BUILDER.buildSpecification(criteria);
    }
}
