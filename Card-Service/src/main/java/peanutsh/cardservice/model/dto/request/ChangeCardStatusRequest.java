package peanutsh.cardservice.model.dto.request;

import peanutsh.cardservice.dictionary.CardStatus;

public record ChangeCardStatusRequest(
        String pan,
        CardStatus status
) {
}
