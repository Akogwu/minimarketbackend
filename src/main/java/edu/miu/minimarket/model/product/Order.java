package edu.miu.minimarket.model.product;

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


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Product> products;

    @OneToOne(mappedBy = "order")
    private OrderStatus order_status;

    @OneToOne
    private Coupon coupon;

}
