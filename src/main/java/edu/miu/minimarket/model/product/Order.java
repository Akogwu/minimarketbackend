package edu.miu.minimarket.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "Order")
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "total_price")
    private double totalPrice;
    private LocalDate date;

    @Column(name = "shipper_name")
    private String shipperName;
    @Column(name = "shipper_apt")
    private String shipperApt;
    @Column(name = "shipper_city")
    private String shipperCity;
    @Column(name = "shipper_state")
    private String shipperState;
    @Column(name = "shipper_country")
    private String shipperCountry;
    @Column(name = "billing_name")
    private String billingName;
    @Column(name = "billing_apt")
    private String billingApt;
    @Column(name = "billing_city")
    private String billingCity;
    @Column(name = "billing_state")
    private String billingState;
    @Column(name = "billing_country")
    private String billingCountry;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "payment_status")
    private String paymentStatus;


    @Column(name = "buyer_id")
    private long buyerId;

    @Column(name = "order_status_id")
    private long orderStatusId;

    @Column(name = "coupon_id")
    private long couponId;



}
