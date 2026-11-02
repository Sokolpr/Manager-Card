package peanutsh.authservice.service.impl;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import peanutsh.authservice.model.entity.User;
import peanutsh.authservice.service.JwtProviderService;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtProviderServiceImpl implements JwtProviderService {

    private final SecretKey secret;
    private final Integer lifeTime;

    public JwtProviderServiceImpl(@Value("${jwt.secret}") String secret,
                           @Value("${spring.data.redis.ttl-minutes}") Integer lifeTime
    ) {
        this.secret = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.lifeTime = lifeTime;
    }

    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + lifeTime*60000))
                .signWith(secret)
                .compact();
    }

    @Override
    public void validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(secret)
                    .build()
                    .parseSignedClaims(token);
        } catch (UnsupportedJwtException unsEx) {
            throw new RuntimeException("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            throw new RuntimeException("Malformed jwt");
        } catch (SignatureException sEx) {
            throw new RuntimeException("Invalid signature");
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Токен истек");
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }

    @Override
    public UUID getSubject(String token, String type) {
        JwtParser jwtParser = Jwts.parser().verifyWith(secret).build();
        return UUID.fromString(
                jwtParser.parseSignedClaims(token).getPayload().getSubject()
        );
    }
}
