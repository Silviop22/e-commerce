package de.dlh.lhind.persistence.criteria;

import org.springframework.data.jpa.domain.Specification;
import java.util.Map;

public class GenericSpecificationBuilder<T> {

    public Specification<T> buildSpecification(Map<String, Object> criteria) {
        if (criteria == null || criteria.isEmpty()) {
            return null;
        }

        Specification<T> result = Specification.where(null);

        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value != null) {
                // Add each criterion to the specification
                result = result.and(createSpecification(key, value));
            }
        }

        return result;
    }

    private Specification<T> createSpecification(String key, Object value) {
        if (key.contains("_gt")) {
            String field = key.replace("_gt", "");
            return (root, query, cb) -> cb.greaterThan(root.get(field),
                    (Comparable) value);
        } else if (key.contains("_lt")) {
            String field = key.replace("_lt", "");
            return (root, query, cb) -> cb.lessThan(root.get(field),
                    (Comparable) value);
        } else if (key.contains("_like")) {
            String field = key.replace("_like", "");
            return (root, query, cb) -> cb.like(root.get(field),
                    "%" + value.toString() + "%");
        } else {
            return (root, query, cb) -> value == null ?
                    cb.isNull(root.get(key)) :
                    cb.equal(root.get(key), value);
        }
    }
}