package br.com.creditcardcontrol.auth.controller;

import br.com.creditcardcontrol.auth.dto.AuthenticationResponse;
import br.com.creditcardcontrol.auth.dto.LoginRequest;
import br.com.creditcardcontrol.auth.dto.RefreshTokenRequest;
import br.com.creditcardcontrol.auth.service.AuthService;
import br.com.creditcardcontrol.auth.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(AuthController.BASE_URL)
public class AuthController {

    public static final String BASE_URL = "/auth";

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh-token")
    public AuthenticationResponse refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteBy(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

