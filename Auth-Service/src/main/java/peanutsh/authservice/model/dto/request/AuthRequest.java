package peanutsh.authservice.model.dto.request;

public record AuthRequest(
        String phoneNumber,
        String password
) {
}
