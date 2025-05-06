package com.rakshan.store.Controllers;


import com.rakshan.store.dtos.ProductDto;
import com.rakshan.store.entities.Product;
import com.rakshan.store.mappers.ProductMapper;
import com.rakshan.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping()
    public List<ProductDto> getAllProducts(@RequestParam(name="categoryId", required = false) Byte categoryId) {

        List<Product> products;

        if(categoryId != null){
            products = productRepository.findByCategoryId(categoryId);
        }else{
            products= productRepository.findAllWithCategory();
        }
        return products
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
}
