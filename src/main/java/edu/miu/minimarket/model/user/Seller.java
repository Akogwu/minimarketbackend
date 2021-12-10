package edu.miu.minimarket.model.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.minimarket.model.product.Product;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class Seller extends User {
    //private String shop;
    private String description;
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "seller")
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private List<Product> products;


}
