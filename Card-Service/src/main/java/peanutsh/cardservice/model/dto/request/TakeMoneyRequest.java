package peanutsh.cardservice.model.dto.request;

public record TakeMoneyRequest(
        String pan,
        String pin,
        int value
) {
}
