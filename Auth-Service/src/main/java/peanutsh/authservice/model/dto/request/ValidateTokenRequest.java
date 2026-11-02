package peanutsh.authservice.model.dto.request;

import java.util.UUID;

public record ValidateTokenRequest(
        String token
){
}
