package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.Follow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public interface FollowRepository extends CrudRepository <Follow, Long> {

    @Query("select f from Follow f where f.sellerid =:id")
    public Follow findSellerById(long id);

}

