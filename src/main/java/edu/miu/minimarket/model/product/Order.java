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
    private String shippername;
    @Column(name = "shipper_apt")
    private String shipperapt;
    @Column(name = "shipper_city")
    private String shippercity;
    @Column(name = "shipper_state")
    private String shipperstate;
    @Column(name = "shipper_country")
    private String shippercountry;
    @Column(name = "billing_name")
    private String billingname;
    @Column(name = "billing_apt")
    private String billingapt;
    @Column(name = "billing_city")
    private String billingcity;
    @Column(name = "billing_state")
    private String billingstate;
    @Column(name = "billing_country")
    private String billingcountry;
    @Column(name = "payment_type")
    private String paymenttype;
    @Column(name = "payment_status")
    private String paymentstatus;

    @Column(name = "buyer_id")
    private long buyer_id;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Product> products;

    @OneToOne(mappedBy = "order")
    private OrderStatus order_status;

    @OneToOne
    private Coupon coupon;

}
