package peanutsh.authservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peanutsh.authservice.model.dto.request.*;
import peanutsh.authservice.model.dto.response.ValidateTokenResponse;
import peanutsh.authservice.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request
            ){
        authService.register(request);
        return ResponseEntity.ok("Вы зарегистрированы");
    }

    @GetMapping("/auth")
    public ResponseEntity<?> auth(
            @RequestBody AuthRequest request
            ){
        return ResponseEntity.ok(authService.auth(request));
    }

    @PostMapping("/reset")
    public ResponseEntity<?> reset(
            @RequestBody ResetPasswordRequest request
    ){
        authService.resetPassword(request);
        return ResponseEntity.ok("Временный пароль отправлен на номер телефона");

    }


    @PatchMapping("/change")
    public ResponseEntity<?> changePassword(
                @RequestBody ChangePasswordRequest request
                ){
        authService.changePassword(request);
        return ResponseEntity.ok("Пароль изменён");
    }

    @PostMapping("/validate")
    public ResponseEntity<ValidateTokenResponse> changePassword(
            @RequestBody ValidateTokenRequest request
    ){

        return ResponseEntity.ok(authService.validateToken(request));
    }

}
