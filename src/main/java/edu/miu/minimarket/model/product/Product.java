package edu.miu.minimarket.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.minimarket.model.user.Seller;
import edu.miu.minimarket.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String image;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "sellerId")
    @JsonBackReference
    private User seller;

    /*Check to be sure
    * */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

}
