package edu.miu.minimarket.repository.product;

import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.OrderDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository <Order, Long> {

//    @Query(value = "select o.lineItems from ord o where o.id=:orderId")
//    public List <OrderDetail> findAllLineItemsByOrderId(long orderId);
//
//    @Query(value = "select b.orders from Buyer b where b.bId=:buyerId")
//    public List<Order> findAllOrdersByBuyerId(long buyerId);
//
//    public Order findOrderById(long id);

}
