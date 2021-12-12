package edu.miu.minimarket.model.product;

import edu.miu.minimarket.model.user.Seller;
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

@Table(name = "Follow")
public class Follow {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "buyer_id")
    private long buyerId;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

}