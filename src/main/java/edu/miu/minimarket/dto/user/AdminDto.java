package edu.miu.minimarket.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AdminDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String role;
}
