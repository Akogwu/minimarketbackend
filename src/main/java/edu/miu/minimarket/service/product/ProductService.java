package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto getById(long id);

    void addProduct(ProductDto user);

    void deleteById(long id);

    List<ProductDto> getProductsById(long id);
}
