package peanutsh.cardservice.model.dto.request;

public record CheckBalanceRequest(
        String pan,
        String pin
) {
}
