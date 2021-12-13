package edu.miu.minimarket.model.product;

import edu.miu.minimarket.model.user.Buyer;
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

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public boolean getApprovalStatus () {
        if (approvalStatus == true) {
            return true;
        } else {
            return false;
        }
    }

}
