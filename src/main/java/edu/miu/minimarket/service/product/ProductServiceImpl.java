package edu.miu.minimarket.service.product;

import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.product.Review;
import edu.miu.minimarket.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct (Product product) {
        return productRepository.save(product);
    }

    @Override
    public List <Product> getAllProduct () {
        return (List <Product>) productRepository.findAll();
    }

    @Override
    public Optional <Product> getProductById (long id) {
        Optional<Product> product = productRepository.getProductById(id);
        return product;
    }

    @Override
    public Product editProduct (long id, Product product) {
        try {
            if (productRepository.existsById(id)){
                Product currentOne=productRepository.findById(id).get();
                if (product.getName()!=null)
                    currentOne.setName(product.getName());
                if (product.getPrice()!=0)
                    currentOne.setPrice(product.getPrice());
                if (product.getQuantity()!=0)
                    currentOne.setQuantity(product.getQuantity());
                if (product.getImage()!=null)
                    currentOne.setImage(product.getImage());
            }
            Product product1=productRepository.save(product);
            return product1;
        }catch (IllegalArgumentException e){
            System.out.println("ADDING ERROR: "+e.getMessage());
            return null;
        }
    }

    @Override
    public Product addReviewToProduct(long id, Review review) {
        try {
            if (productRepository.existsById(id)){
                Product product = productRepository.getProductById(id).orElse(null);

                review.setProduct(product);
                List<Review> reviews = product.getReviews();
                reviews.add(review);
                return productRepository.save(product);
            }
            return null;
        }catch (IllegalArgumentException e){
            System.out.println("AddReview ERROR: "+e.getMessage());
            return null;
        }
    }

    @Override
    public List <Review> getAllReviewsForProduct (long id) {
        try {
            if (productRepository.existsById(id)){
                return productRepository.findAllReviewsForProduct(id).stream()
                        .filter(review -> review.getApprovalStatus())
                        .collect(Collectors.toList());
            }
            return null;
        }catch (IllegalArgumentException e){
            System.out.println("GETALLREVIEWS ERROR: "+e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteProduct(long product_id, long seller_id) {
        try {
            if (productRepository.deletableProduct(product_id).size()==0 || productRepository.deletableProduct(product_id) == null) {
                productRepository.deleteById(product_id);
                return true;
            }
            throw new IllegalArgumentException("Can't Delete This product "+product_id+"because it's purchased before.");
        }catch (IllegalArgumentException e){
            System.out.println("Delete ERROR: "+e.getMessage());
            return false;
        }
    }

}
