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

@Table(name = "Coupon")
public class Coupon {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String coupon;
    private double amount;
    private LocalDate date;
    @Column(name = "use_status")
    private boolean useStatus;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;



}
