package br.com.creditcardcontrol.auth.service;

import br.com.creditcardcontrol.auth.dto.AuthenticationResponse;
import br.com.creditcardcontrol.auth.dto.LoginRequest;

public interface AuthService {
    AuthenticationResponse login(LoginRequest loginRequest);
}
