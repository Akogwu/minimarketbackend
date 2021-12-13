package edu.miu.minimarket.controller;


import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.product.Review;
import edu.miu.minimarket.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
//@CrossOrigin("*")

public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping()
    public List <Product> getAll(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Product editProduct(@PathVariable long id,@RequestBody Product product){
        return productService.editProduct(id,product);
    }

    @PostMapping("/{id}/review")
    public Product addReview(@RequestBody Review review, @PathVariable long id){
        return productService.addReviewToProduct(id,review);
    }

    @GetMapping("/{id}/reviews")
    public List<Review> getAllReviewsForProduct(@PathVariable long id){
        return productService.getAllReviewsForProduct(id);
    }

}
