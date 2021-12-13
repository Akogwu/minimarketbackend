package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.product.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository <Product,Long> {

    @Query(value = "select prod from Product prod where prod.id=:id")
    public Optional <Product> getProductById(long id);

    @Query(value = "select p.reviews from Product p where p.id=:productID")
    public List<Review> findAllReviewsForProduct(long productID);

    @Query("select od.product_id from OrderDetail od where od.product_id=:id")
    public List<Long> deletableProduct(@Param("id") long id);

}