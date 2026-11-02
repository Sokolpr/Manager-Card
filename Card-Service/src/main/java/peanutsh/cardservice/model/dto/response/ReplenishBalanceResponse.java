package peanutsh.cardservice.model.dto.response;

public record ReplenishBalanceResponse(
        String pan,
        String pin,
        int value

){
}
