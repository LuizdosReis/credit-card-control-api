package br.com.creditcardcontrol.auth.service;

import br.com.creditcardcontrol.auth.model.RefreshToken;
import br.com.creditcardcontrol.auth.repository.RefreshTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository repository;

    @Override
    public RefreshToken generate() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());

        return repository.save(refreshToken);
    }

    @Override
    public void validateBy(String token) {
        repository.findByToken(token)
            .orElseThrow(() -> new RuntimeException("Invalid refresh Token"));

    }

    @Override
    public void deleteBy(String token){
        repository.deleteByToken(token);
    }
}
