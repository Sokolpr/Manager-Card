package peanutsh.authservice.service;

import peanutsh.authservice.model.dto.request.*;
import peanutsh.authservice.model.dto.response.AuthResponse;
import peanutsh.authservice.model.dto.response.ValidateTokenResponse;

public interface AuthService {

    void register(RegisterRequest request);
    AuthResponse auth(AuthRequest request);
    void resetPassword(ResetPasswordRequest request);
    void changePassword(ChangePasswordRequest request);
    ValidateTokenResponse validateToken(ValidateTokenRequest request);
}
