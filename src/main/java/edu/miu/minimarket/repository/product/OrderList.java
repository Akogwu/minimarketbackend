package edu.miu.minimarket.repository.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderList extends CrudRepository<OrderList,Long> {
}
