package edu.miu.minimarket.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.minimarket.model.user.Seller;
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

@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private int quantity;
    private double price;


    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonBackReference
    private Seller seller;

    @OneToMany
    private List<Review> reviews;




}
