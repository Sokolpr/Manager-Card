package peanutsh.authservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peanutsh.authservice.model.dto.request.*;
import peanutsh.authservice.model.dto.response.AuthResponse;
import peanutsh.authservice.model.dto.response.ValidateTokenResponse;
import peanutsh.authservice.model.entity.User;
import peanutsh.authservice.repository.TokenRepository;
import peanutsh.authservice.repository.UserRepository;
import peanutsh.authservice.service.AuthService;
import peanutsh.authservice.service.JwtProviderService;
import peanutsh.authservice.service.PasswordService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtProviderService jwtProviderService;

    @Override
    public void changePassword(ChangePasswordRequest request) {

    }

    @Override
    public ValidateTokenResponse validateToken(ValidateTokenRequest request) {
        return null;
    }

    private final PasswordService passwordService;

    @Transactional
    @Override
    public void register(RegisterRequest request) {
        if(userRepository.existsByPhoneNumber(request.phoneNumber())){
            throw  new RuntimeException();
        }

        User user = new User();

        user.setPassword(passwordService.hashPassword(request.phoneNumber()));
        user.setPhoneNumber(request.phoneNumber());

        userRepository.save(user);

        // ToDo отправить данные в профиль сервис
    }

    @Transactional
    @Override
    public AuthResponse auth(AuthRequest request) {

        User user = identification(request);

        String token = jwtProviderService.generateToken(user);
        tokenRepository.saveAuthToken(token, user.getId());

        return new AuthResponse(token);
    }

    @Transactional
    @Override
    public void resetPassword(ResetPasswordRequest request) {

        User user = userRepository.findByPhoneNumber(request.phoneNumber()).orElseThrow(()->  new RuntimeException("user not found"));

            String tempPassword = passwordService.generateNewPassword();

            //Todo отправить временный пароль куда либо
        }




   private User identification(AuthRequest request){
        User user = userRepository.findByPhoneNumber(request.phoneNumber()).orElseThrow(()->  new RuntimeException("user not found"));

            if (passwordService.checkPassword(request.password(), user.getPassword())){
                return user;
            }

        throw new RuntimeException("");
    }
}
