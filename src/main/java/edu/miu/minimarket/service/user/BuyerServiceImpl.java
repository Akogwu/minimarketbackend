package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.product.OrderDto;
import edu.miu.minimarket.dto.user.BuyerDto;
import edu.miu.minimarket.model.product.*;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.repository.product.OrderDetailRepository;
import edu.miu.minimarket.repository.product.OrderRepository;
import edu.miu.minimarket.repository.user.BuyerRepository;
import edu.miu.minimarket.service.product.FollowService;
import edu.miu.minimarket.service.product.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    FollowService followService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Buyer save (BuyerDto buyerDto) {
        return buyerRepository.save(modelMapper.map(buyerDto, Buyer.class));
    }

    @Override
    public Buyer editBuyer (long id, Buyer buyer) {
        try {
            Buyer Old = buyerRepository.findById(id).orElse(null);
            return buyerRepository.save(buyer);
        }catch (IllegalArgumentException e){
            System.out.println("Error Edit Buyer:"+e);
            return null;
        }
    }

    @Override
    public List <Buyer> getAllBuyers () {
        return buyerRepository.findAllBuyers();
    }

    @Override
    public Buyer getBuyerById (long id) {
        return buyerRepository.findBuyerById(id);
    }

    @Override
    public List <Seller> getAllSellerFollowedByBuyer (long id) {
        return buyerRepository.getAllSellerFollowedByBuyer(id);
    }

    @Override
    public void followSeller (long buyerId, long sellerId) {

        Follow follow = new Follow();
        follow.setBuyerid(buyerId);
        follow.setSellerid(sellerId);
        if (!followService.sellerIsExist(sellerId)) {
            followService.save(follow);
        }
    }

    @Override
    public void unFollowSeller (long buyerId, long sellerId) {
        Follow follow = new Follow();
        follow.setBuyerid(buyerId);
        follow.setSellerid(sellerId);
        if (followService.sellerIsExist(sellerId)) {
            followService.deleteFollow(sellerId);
        }
    }

    @Override
    public void addOrder (OrderDto orderDto, long id) {

        List <Product> products = orderDto.getProducts();
        Order order = orderRepository.save(modelMapper.map(orderDto, Order.class));

        for (Product product: products) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder_id(order.getId());
            orderDetail.setProduct_id(product.getId());
            orderDetail.setProductname(product.getName());
            orderDetail.setQuantity(product.getQuantity());
            orderDetail.setPrice(product.getPrice());
            orderDetailRepository.save(orderDetail);
        }

        sendEmail("luqmang316@gmail.com", "test", "Test message");

    }

    @Override
    public List <Order> getAllOrdersForBuyer (long id) {
        return buyerRepository.getAllOrdersByBuyerId(id);
    }

    @Override
    public List <OrderDetail> getOrderDetails (long buyerid, long orderid) {
        return buyerRepository.getOrderDetails(orderid);
    }

    @Override
    public boolean deleteOrder (long buyerid, long orderid) {

        Order order = orderService.getOrderById(orderid);
        if (order.getOrder_status().getStatusname() != OrderStatusEnum.Shipped.getOrderStatusEnum() || order.getOrder_status( ).getStatusname() != OrderStatusEnum.Delivered.getOrderStatusEnum( )){
            orderService.deleteById(orderid);
            return true;
        }
        return false;
    }


    private void sendEmail(String emailUser, String subject, String text) {
        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(emailUser);
            email.setSubject(subject);
            email.setText(text);
            mailSender.send(email);
            System.out.println("Email is Sent");
        }catch (Exception ex)
        {System.out.println(ex.getMessage());}
    }


}

