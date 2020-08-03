package br.com.creditcardcontrol.auth.service;

import br.com.creditcardcontrol.auth.dto.AuthenticationResponse;
import br.com.creditcardcontrol.auth.dto.LoginRequest;
import br.com.creditcardcontrol.auth.dto.RefreshTokenRequest;

public interface AuthService {
    AuthenticationResponse login(LoginRequest loginRequest);

    AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
