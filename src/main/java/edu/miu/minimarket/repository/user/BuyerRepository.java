package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.OrderDetail;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository extends CrudRepository <Buyer, Long> {

    @Query("select b from Buyer b")
    public List <Buyer> findAllBuyers();

    @Query("select b from Buyer b where b.id=:id")
    public Buyer findBuyerById(@Param("id")long id);

    @Query("select f from Follow f where f.buyerid=:id")
    public List <Seller> getAllSellerFollowedByBuyer(@Param("id") long id);

//    //select * from orderDetail od, buyer b , order o where od.orderId = o.orderId AND o.bId = id
//    @Query(value = "select od from OrderDetail od, Buyer b, Order o where od.order_id = o.id AND o.buyer_id =: id", nativeQuery = true)
//    public List<OrderDetail> getAllOrdersByBuyerId(long id);

    @Query("select o from Order o where o.buyer_id =: id")
    public List<Order> getAllOrdersByBuyerId(@Param("id") long id);

    @Query("select od from OrderDetail od where od.order_id =: id")
    public List<OrderDetail> getOrderDetails(@Param("id") long id);


}