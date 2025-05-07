package de.dlh.lhind.product.domain.persistence.repository;

import de.dlh.lhind.product.domain.persistence.model.Category;
import de.dlh.lhind.product.domain.persistence.model.Product;
import de.dlh.lhind.product.domain.persistence.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Set<Product> findByName(String name);
    @Query(value = """ 
            SELECT p FROM Product p
            JOIN FETCH p.subCategory sc
            JOIN FETCH sc.category c
            WHERE p.id = :id
            """)
    Set<Product> findByCategory(Category category);
    Set<Product> findBySubCategory(SubCategory subCategory);

}
