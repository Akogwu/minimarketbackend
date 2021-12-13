package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.product.OrderDto;
import edu.miu.minimarket.dto.user.BuyerDto;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.OrderDetail;
import edu.miu.minimarket.model.user.Admin;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Seller;

import java.util.List;

public interface BuyerService {

    public Buyer save(BuyerDto buyerDto);

    public Buyer editBuyer(long id, Buyer buyer);

    public List <Buyer> getAllBuyers();

    public Buyer getBuyerById(long id);

    public List<Seller> getAllSellerFollowedByBuyer(long id);

    public void followSeller(long buyerId, long sellerId);

    public void unFollowSeller(long buyerId, long sellerId);

    public void addOrder(OrderDto orderDto, long id);

    public List<Order> getAllOrdersForBuyer(long id);

    public List<OrderDetail> getOrderDetails(long buyerid, long orderid);

    public boolean deleteOrder(long buyerid, long orderid);

}
