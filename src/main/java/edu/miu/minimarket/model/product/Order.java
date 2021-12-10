package edu.miu.minimarket.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.minimarket.model.user.Buyer;
import edu.miu.minimarket.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double totalPrice;
    /**Todo
     * use enum for order status
    * */
    private String status;

    @ManyToOne
    @JoinColumn(name = "buyerId")
    @JsonBackReference
    private User buyer;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Receipt receipt;

}
