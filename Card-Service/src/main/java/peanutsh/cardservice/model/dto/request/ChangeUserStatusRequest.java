package peanutsh.cardservice.model.dto.request;

import peanutsh.cardservice.dictionary.UserStatus;

import java.util.UUID;

public record ChangeUserStatusRequest(
        UUID userId,
        UserStatus userStatus
) {
}
