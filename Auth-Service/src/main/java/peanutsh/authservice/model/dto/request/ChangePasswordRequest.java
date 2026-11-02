package peanutsh.authservice.model.dto.request;

public record ChangePasswordRequest(
        String phoneNumber,
        String password
) {
}
