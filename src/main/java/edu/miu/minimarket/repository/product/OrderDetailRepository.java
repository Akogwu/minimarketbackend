package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public interface OrderDetailRepository extends CrudRepository <OrderDetail, Long> {

}
