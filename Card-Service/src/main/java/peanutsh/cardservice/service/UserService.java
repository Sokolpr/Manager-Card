package peanutsh.cardservice.service;

import peanutsh.cardservice.model.dto.request.CreateUserRequest;
import peanutsh.cardservice.model.dto.request.ChangeCardStatusRequest;
import peanutsh.cardservice.model.dto.request.ChangeUserStatusRequest;
import peanutsh.cardservice.model.dto.request.CreateCardRequest;
import peanutsh.cardservice.model.dto.response.*;

import java.util.UUID;

public interface UserService {

    CreateUserResponse createUser(UUID authUserId, CreateUserRequest createUserRequest);

    CreateCardResponse createCard(UUID authUserId, CreateCardRequest createCardRequest);

    GetAllMyCardResponse getAllCards(UUID authUserId);

    ChangeCardStatusResponse changeStatusCard(UUID authUserId, ChangeCardStatusRequest changeCardStatusRequest);

    ChangeUserStatusResponse changeUserStatus (ChangeUserStatusRequest changeUserStatus);
}
