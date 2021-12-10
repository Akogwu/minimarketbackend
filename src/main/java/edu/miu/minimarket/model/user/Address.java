package edu.miu.minimarket.model.user;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apartNo;
    private String zipcode;
    private String street;
    private String state;
    private String country;

}
