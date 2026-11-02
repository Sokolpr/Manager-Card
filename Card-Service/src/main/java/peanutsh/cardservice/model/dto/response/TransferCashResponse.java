package peanutsh.cardservice.model.dto.response;

public record TransferCashResponse(
        String myCardPan,
        String pin,
        int value,
        String otherCardPen) {


}
