package peanutsh.cardservice.model.dto.response;

public record CreateCardResponse(
        String pan,
        String expMonth,
        String expYear,
        String cvv
) {
}
