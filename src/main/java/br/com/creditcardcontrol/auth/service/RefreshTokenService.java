package br.com.creditcardcontrol.auth.service;

import br.com.creditcardcontrol.auth.model.RefreshToken;

public interface RefreshTokenService {
    RefreshToken generate();

    void validateBy(String token);

    void deleteBy(String token);
}
