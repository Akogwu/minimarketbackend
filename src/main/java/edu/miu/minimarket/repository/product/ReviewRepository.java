package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Long> {
}
