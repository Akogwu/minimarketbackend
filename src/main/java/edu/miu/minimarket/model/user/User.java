package edu.miu.minimarket.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    Long id = 0L;

    String name = null;
    String username = null;
    String password = null;
    String phone = null;
    String email = null;
    boolean active = true;

    @OneToOne
    private Role role;

}
