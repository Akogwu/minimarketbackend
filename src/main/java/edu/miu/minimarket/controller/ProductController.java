package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.ProductDto;
import edu.miu.minimarket.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable long id){ return productService.getById(id); }

    @PostMapping
    public void addPost(@RequestBody ProductDto product){
        productService.addProduct(product);
    }

    @GetMapping("/{id}/products")
    public List<ProductDto> getProduct(@PathVariable long id) { return productService.getProductsById(id);
    }

    @GetMapping("/{id}/products/{pid}")
    public ProductDto getOneProduct(@PathVariable("pid") long id) { return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.deleteById(id);
    }

}
