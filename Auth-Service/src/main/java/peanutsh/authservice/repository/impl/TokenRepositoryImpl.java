package peanutsh.authservice.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import peanutsh.authservice.repository.TokenRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

   private final RedisTemplate<String,UUID> redisTemplate;

   private static final String CACHE_KEY_PREFIX = "token:";

    @Value("${spring.data.redis.ttl-minutes}")
    private Long CACHE_TTL_MINUTES;

    @Override
    public Optional<UUID> getAuthId(String token) {

        String key = CACHE_KEY_PREFIX + token;

        return Optional.ofNullable(redisTemplate.opsForValue().get(key));
    }

    @Override
    public void saveAuthToken(String token, UUID authId) {

        String key = CACHE_KEY_PREFIX + token;

        redisTemplate.opsForValue().
                set(key, authId, CACHE_TTL_MINUTES, TimeUnit.MINUTES);
    }

}
