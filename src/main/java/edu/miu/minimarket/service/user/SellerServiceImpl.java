package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.user.SellerDto;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.OrderStatus;
import edu.miu.minimarket.model.product.OrderStatusEnum;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.repository.user.SellerRepository;
import edu.miu.minimarket.service.product.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    SellerService sellerService;
    @Autowired
    OrderService orderService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Seller save (SellerDto sellerDto) {
        return sellerRepository.save(modelMapper.map(sellerDto, Seller.class));
    }

    @Override
    public Seller getSellerById (long id) {
        return sellerRepository.findSellerById(id);
    }

    @Override
    public List <Seller> getAllSeller () {
        return (List<Seller>) sellerRepository.findAll();
    }

    @Override
    public List <Order> getOrdersBySeller (long id) {
        return sellerRepository.getOrdersBySeller(id);
    }

    @Override
    public Order shipSellerOrder (long sellerid, long oId) {

        Seller seller =sellerRepository.findSellerById(sellerid);
        List<Long> lOID= this.getOrderIdsBySellerBySId(seller.getId());

        if(lOID.contains(oId)) {
            Order order = orderService.getOrderById(oId);

            OrderStatus newOrderStatus = order.getOrder_status();
            newOrderStatus.setStatusname(OrderStatusEnum.Shipped.getOrderStatusEnum( ));
            order.setOrder_status(newOrderStatus);
            orderService.save(order);
            sellerService.save(modelMapper.map(seller, SellerDto.class));
            return order;
        }
        return null;
    }

    @Override
    public Order cancelSellerOrder(long sellerid, long oId) {

        Seller seller = sellerService.getSellerById(sellerid);
        List<Long> lOID = sellerService.getOrderIdsBySellerBySId(seller.getId());

        if( lOID.contains(oId)) {

            Order order= orderService.getOrderById(oId);

            if (order.getOrder_status().getStatusname() != OrderStatusEnum.Shipped.getOrderStatusEnum()) {
                OrderStatus newOrderStatus = order.getOrder_status();
                newOrderStatus.setStatusname(OrderStatusEnum.Cancelled.getOrderStatusEnum( ));
                order.setOrder_status(newOrderStatus);
            }
            orderService.save(order);
            return order;
        }
        return null;
    }

    @Override
    public List <Long> getOrderIdsBySellerBySId (long sId) {

        return sellerRepository.getOrdersBySellerBySId(sId);
    }
}
