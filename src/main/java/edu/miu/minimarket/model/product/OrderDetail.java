package edu.miu.minimarket.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

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
    private Long id;

    @Column(name = "product_name")
    private String productname;
    private int quantity;
    private double price;
    private long order_id;
    private long product_id;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @Fetch(FetchMode.JOIN)
//    private List<Order> orders;
//
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @Fetch(FetchMode.JOIN)
//    private List<Product> products;

}
