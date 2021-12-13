package edu.miu.minimarket.model.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
//import edu.miu.minimarket.model.product.Follow;
//import edu.miu.minimarket.model.product.Product;
import edu.miu.minimarket.model.product.Follow;
import edu.miu.minimarket.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "SELLER")
public class Seller {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    private String email;
    private String username;
    private String password;

    @Column(name = "approval_status")
    private boolean approvalstatus;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private List<Product>  products;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private List<Follow> follows;

}