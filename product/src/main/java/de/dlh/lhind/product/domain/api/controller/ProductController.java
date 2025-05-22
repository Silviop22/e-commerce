package de.dlh.lhind.product.domain.api.controller;

import de.dlh.lhind.product.domain.api.model.ProductDto;
import de.dlh.lhind.product.domain.service.ProductService;
import org.h2.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getList(@RequestParam int page,
                                                    @RequestParam int size,
                                                    @RequestParam(required = false) String category,
                                                    @RequestParam(required = false) String subcategory){
        Map<String, Object> filter = Map.of();
        if (!StringUtils.isNullOrEmpty(category)) {
            filter.put("category", category);
        }
        if (!StringUtils.isNullOrEmpty(subcategory)) {
            filter.put("subcategory", subcategory);
        }
        Page<ProductDto> productPage = productService.getList(page, size, filter);
        return ResponseEntity.ok(productPage);
    }
}
