package com.rakshan.store.repositories;

import com.rakshan.store.dtos.ProductDto;
import com.rakshan.store.entities.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte categoryId);


    @Query("SELECT p from Product p JOIN FETCH p.category")
    List<Product> findAllWithCategory();
}