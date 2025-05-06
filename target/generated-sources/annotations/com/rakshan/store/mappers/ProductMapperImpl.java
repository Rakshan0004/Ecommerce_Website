package com.rakshan.store.mappers;

import com.rakshan.store.dtos.ProductDto;
import com.rakshan.store.entities.Category;
import com.rakshan.store.entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T16:40:33+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setCategoryId( productCategoryId( product ) );
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );
        productDto.setDescription( product.getDescription() );

        return productDto;
    }

    private Byte productCategoryId(Product product) {
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getId();
    }
}
