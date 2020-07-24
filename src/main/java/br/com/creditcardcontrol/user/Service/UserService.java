package br.com.creditcardcontrol.user.Service;

import br.com.creditcardcontrol.user.dto.UserRequest;
import br.com.creditcardcontrol.user.model.User;
import br.com.creditcardcontrol.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void create(UserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setName(userRequest.getName());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());
        user.setEnabled(true);

        userRepository.save(user);
    }

}
