package edu.miu.minimarket.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "Order_Detail")
public class OrderDetail {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    private String productName;
    private int quantity;
    private double price;

    @Column(name = "order_id")
    private long orderId;
    @Column(name = "product_id")
    private long productId;

}
