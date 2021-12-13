package edu.miu.minimarket.controller;

import edu.miu.minimarket.dto.user.SellerDto;
import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.service.product.ProductService;
import edu.miu.minimarket.service.user.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
//@CrossOrigin("http://localhost:3000/")

public class SellerController {

    @Autowired
    SellerService sellerService;

    @Autowired
    ProductService productService;

    @PostMapping
    public void addSeller(@RequestBody SellerDto sellerDto) {
        sellerService.save(sellerDto);
    }

    @GetMapping("/{id}")
    private Seller getSeller(@PathVariable long id){
        return sellerService.getSellerById(id);
    }

    @GetMapping
    public List <Seller> getSellers(){
        return sellerService.getAllSeller();
    }

    @GetMapping("/{id}/orders")
    public List<Order> getOrdersBySellerId(@PathVariable("id") long id){
        return sellerService.getOrdersBySeller(id);
    }

    @PostMapping("/{userName}")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("{seller_id}/products/{product_id}")
    public boolean deleteProduct(@PathVariable long product_id, @PathVariable long seller_id){
        return productService.deleteProduct(product_id,seller_id);
    }

    @PostMapping("/{seler_id}/order/cancel/{id}")
    public Order cancelSellerOrder(@PathVariable("seler_id") long seler_id, @PathVariable("id") long oId){
        return sellerService.cancelSellerOrder(seler_id, oId);
    }

//    @PostMapping("/{userName}/order/shipped/{id}")
//    public Order shipSellerOrder(@PathVariable("userName") String userName,@PathVariable("id") long oId){
//        return sellerService.shipSellerOrder(userName,oId);
//    }

}



