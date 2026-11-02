package peanutsh.cardservice.model.dto.request;

public record ReplenishBalanceRequest(
        String pan,
        String pin,
        int value

){
}
