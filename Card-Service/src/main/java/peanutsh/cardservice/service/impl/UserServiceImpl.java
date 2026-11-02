package peanutsh.cardservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peanutsh.cardservice.dictionary.UserStatus;
import peanutsh.cardservice.mapper.UserMapper;
import peanutsh.cardservice.model.dto.request.ChangeCardStatusRequest;
import peanutsh.cardservice.model.dto.request.ChangeUserStatusRequest;
import peanutsh.cardservice.model.dto.request.CreateCardRequest;
import peanutsh.cardservice.model.dto.request.CreateUserRequest;
import peanutsh.cardservice.model.dto.response.*;
import peanutsh.cardservice.model.entity.User;
import peanutsh.cardservice.repository.CardRepository;
import peanutsh.cardservice.repository.UserRepository;
import peanutsh.cardservice.service.UserService;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final UserMapper userMapper;


    @Override
    @Transactional
    public CreateUserResponse createUser(UUID userId, CreateUserRequest createUserRequest) {

        User user = userMapper.toEntity(createUserRequest,userId);
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);

        return new CreateUserResponse("Пользователь создан");
    }

    @Override
    public CreateCardResponse createCard(UUID authUserId, CreateCardRequest createCardRequest) {

        User user = findUser(authUserId);

        Card card =



        return null;
    }

    @Override
    public GetAllMyCardResponse getAllCards(UUID authUserId) {


        return null;
    }

    @Override
    public ChangeCardStatusResponse changeStatusCard(UUID authUserId, ChangeCardStatusRequest changeCardStatusRequest) {
        return null;
    }

    @Override
    public ChangeUserStatusResponse changeUserStatus(ChangeUserStatusRequest changeUserStatus) {
        return null;
    }

    private User findUser(UUID authUserId){
        return userRepository.findById(authUserId).orElseThrow();
    }


}
