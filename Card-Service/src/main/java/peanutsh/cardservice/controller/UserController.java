package peanutsh.cardservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peanutsh.cardservice.model.dto.request.ChangeUserStatusRequest;
import peanutsh.cardservice.model.dto.request.CreateUserRequest;
import peanutsh.cardservice.model.dto.request.ChangeCardStatusRequest;
import peanutsh.cardservice.model.dto.request.CreateCardRequest;
import peanutsh.cardservice.model.dto.response.*;
import peanutsh.cardservice.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<CreateUserResponse> createUser(
            @RequestHeader("X-Auth-UserId") UUID authUserId,
            @RequestBody CreateUserRequest createUserRequest
    ) {
        return ResponseEntity.ok(userService.createUser(authUserId, createUserRequest));
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCardResponse> createCard(
            @RequestHeader("X-Auth-UserId") UUID authUserId,
            @RequestBody CreateCardRequest createCardRequest
    ) {
        return ResponseEntity.ok(userService.createCard(authUserId, createCardRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<GetAllMyCardResponse> getAllMyCard(
            @RequestHeader("X-Auth-UserId") UUID authUserId
    ) {
        return ResponseEntity.ok(userService.getAllCards(authUserId));
    }

    @PatchMapping("")
    public ResponseEntity<ChangeCardStatusResponse> changeCardStatus(
            @RequestHeader("X-Auth-UserId") UUID authUserId,
            @RequestBody ChangeCardStatusRequest changeCardStatusRequest
    ) {
        return ResponseEntity.ok(userService.changeStatusCard(authUserId, changeCardStatusRequest));
    }

    @PostMapping
    public ResponseEntity<ChangeUserStatusResponse> changeUserStatus (
            @RequestBody ChangeUserStatusRequest changeUserStatusRequest
    ){
        return ResponseEntity.ok(userService.changeUserStatus(changeUserStatusRequest));
    }

}
