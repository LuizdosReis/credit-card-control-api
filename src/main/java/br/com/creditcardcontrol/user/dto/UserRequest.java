package br.com.creditcardcontrol.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String email;
    private String name;
    private String username;
    private String password;
}
