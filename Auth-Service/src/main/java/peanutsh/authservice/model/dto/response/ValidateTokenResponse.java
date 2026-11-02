package peanutsh.authservice.model.dto.response;

import java.util.UUID;

public record ValidateTokenResponse (
        UUID authId
){
}
