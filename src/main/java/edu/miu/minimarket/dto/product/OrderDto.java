package edu.miu.minimarket.dto.product;


import edu.miu.minimarket.model.product.Coupon;
import edu.miu.minimarket.model.product.OrderStatus;
import edu.miu.minimarket.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrderDto {

    private long id;
    private double totalPrice;
    private LocalDate date;
    private String shipperName;
    private String shipperApt;
    private String shipperCity;
    private String shipperState;
    private String shipperCountry;
    private String billingName;
    private String billingApt;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String paymentType;
    private String paymentStatus;
    private List <Product> products;
    private OrderStatus order_status;
    private Coupon coupon;

}
