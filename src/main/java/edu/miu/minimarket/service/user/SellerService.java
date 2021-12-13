package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.user.SellerDto;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.user.Seller;

import java.util.List;

public interface SellerService {

    public Seller save(SellerDto sellerDto);

    public Seller getSellerById(long id);

    public List<Seller> getAllSeller();

    public List<Order> getOrdersBySeller(long id);

    public Order shipSellerOrder(long sellerid, long oId);

    public Order cancelSellerOrder(long sellerid, long oId);

    public List<Long> getOrderIdsBySellerBySId(long sId);


}
