package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.user.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository <Seller, Long> {

    @Query("select s from Seller s where s.id=:id")
    public Seller findSellerById(@Param("id")long id);

    @Query(value = "select o from Order o, OrderDetail od, Product p where o.id= od.order_id AND od.product_id = p.id AND p.seller.id =: id", nativeQuery = true)
    public List<Order> getOrdersBySeller(long id);

    @Query(value = "select o.id from Order o, OrderDetail od, Product p where o.id= od.order_id AND od.product_id = p.id AND p.seller.id =: id", nativeQuery = true)
    public List<Long> getOrdersBySellerBySId(@Param("sId") long id);

    /*
    @Query(value = "SELECT DISTINCT ord_id FROM maskm_db.ord_line_items where line_items_id in " +
            "(SELECT li.id FROM maskm_db.line_item li where product_id  in " +
            "(SELECT products_id FROM maskm_db.seller_products where seller_s_id=:sId ))",nativeQuery = true)
    public List<Long> getOrdersBySellerBySId(@Param("sId") long sId);
     */
}
