package edu.miu.minimarket.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity

@Table(name = "Review")
public class Review {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "review_txt")
    private String reviewTxt;
    private LocalDate date;
    @Column(name = "approval_status")
    private boolean approvalStatus;

    @Column(name = "buyer_id")
    private long buyerId;
    @Column(name = "product_id")
    private long productId;

}
