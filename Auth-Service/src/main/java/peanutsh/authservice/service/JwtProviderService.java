package peanutsh.authservice.service;

import peanutsh.authservice.model.entity.User;

import java.util.UUID;

public interface JwtProviderService {

    String generateToken(User user);

    void validateToken(String token);

    UUID getSubject(String token, String type);

}
