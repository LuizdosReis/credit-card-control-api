package br.com.creditcardcontrol.auth.controller;

import br.com.creditcardcontrol.auth.dto.AuthenticationResponse;
import br.com.creditcardcontrol.auth.service.AuthService;
import br.com.creditcardcontrol.auth.dto.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(AuthController.BASE_URL)
public class AuthController {

    public static final String BASE_URL = "/auth";

    private final AuthService authService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}

