package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.product.OrderDto;
import edu.miu.minimarket.dto.user.AdminDto;
import edu.miu.minimarket.dto.user.BuyerDto;
import edu.miu.minimarket.dto.user.SellerDto;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.OrderDetail;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.service.user.AdminService;
import edu.miu.minimarket.service.user.BuyerService;
import edu.miu.minimarket.service.user.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
//@CrossOrigin("http://localhost:3000/")

public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @Autowired
    SellerService sellerService;

    @PostMapping
    public void addBuyer(@RequestBody BuyerDto buyerDto) {
        buyerService.save(buyerDto);
    }

    @PutMapping("/profile/{id}")
    public void ediBuyer(@RequestBody Buyer buyer, long id){
        buyerService.editBuyer(id,buyer);
    }

    @GetMapping
    public List <Buyer> getAllBuyer(){
        return buyerService.getAllBuyers();
    }

    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable("id") long id){
        return buyerService.getBuyerById(id);
    }

    @GetMapping("/{id}/follow")
    public List<Seller> getAllSellerFollowedByBuyer(@PathVariable long id){
        return buyerService.getAllSellerFollowedByBuyer(id);
    }

    @PostMapping("/{buyerId}/follow/{sellerId}")
    public void followSeller(@PathVariable long buyerId, @PathVariable long sellerId){
        buyerService.followSeller(buyerService.getBuyerById(buyerId).getId(),
                sellerService.getSellerById(sellerId).getId());
    }

    @PostMapping("/{buyerId}/unfollow/{sellerId}")
    public void unFollowSeller(@PathVariable long buyerId, @PathVariable long sellerId){
        buyerService.unFollowSeller(
                buyerService.getBuyerById(buyerId).getId(),
                sellerService.getSellerById(sellerId).getId());
    }

    @PostMapping("/{id}/order")
    public void addOrder(@RequestBody OrderDto orderDto, @PathVariable long id){
        buyerService.addOrder(orderDto,id);
    }

    @GetMapping("/{id}/orders")
    public List<Order> getAllOrdersForBuyer(@PathVariable long id){
        return buyerService.getAllOrdersForBuyer(id);
    }

    @GetMapping("/{buyerid}/order/{id}/orderdetails")
    public List<OrderDetail> listOrderItems(@PathVariable("buyerid") long buyerid, @PathVariable("id") long id){
        return buyerService.getOrderDetails(buyerid, id);
    }

    @DeleteMapping("/{buyerid}/order/{id}")
    public boolean deleteOrder(@PathVariable("buyerid") long buyerid, @PathVariable("id") long id){
        return buyerService.deleteOrder(buyerid,id);
    }


}