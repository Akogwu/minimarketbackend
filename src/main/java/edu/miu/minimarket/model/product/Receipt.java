package edu.miu.minimarket.model.product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Receipt {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private double totalPrice;
   private int quantity;
   private LocalDate date;

   /*Verify to be sure
   * */
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "receipt")
   @JoinColumn(name = "orderId")
   private Order order;

}
