package peanutsh.authservice.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepository {
    Optional<UUID> getAuthId(String token);
    void saveAuthToken(String token,UUID authId);
}
