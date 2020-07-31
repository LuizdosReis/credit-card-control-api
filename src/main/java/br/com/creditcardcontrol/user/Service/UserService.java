package br.com.creditcardcontrol.user.Service;

import br.com.creditcardcontrol.user.dto.UserRequest;
import br.com.creditcardcontrol.user.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void create(UserRequest userRequest);
    User loadUserByUsername(String username);
    User getCurrentUser();
}
