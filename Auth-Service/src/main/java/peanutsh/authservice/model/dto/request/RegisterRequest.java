package peanutsh.authservice.model.dto.request;

public record RegisterRequest(
        String phoneNumber,
        String password
) {
}
