package edu.miu.minimarket.service.product;


import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.product.Review;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product addProduct(Product product);

    public List <Product> getAllProduct();

    public Optional <Product> getProductById(long id);

    public Product editProduct(long id,Product product);

    public boolean deleteProduct(long product_id, long seller_id);

    public Product addReviewToProduct(long id, Review review);

    public List<Review> getAllReviewsForProduct(long id);


}
