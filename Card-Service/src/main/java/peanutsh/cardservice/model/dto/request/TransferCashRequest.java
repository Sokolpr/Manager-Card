package peanutsh.cardservice.model.dto.request;

public record TransferCashRequest(
        String myCardPan,
        String pin,
        int value,
        String otherCardPen) {


}
