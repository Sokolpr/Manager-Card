package peanutsh.cardservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peanutsh.cardservice.model.dto.request.*;
import peanutsh.cardservice.model.dto.response.*;
import peanutsh.cardservice.service.CardService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/card")
public class CardController {

    private final CardService cardService;


    @PostMapping()
    public ResponseEntity<ReplenishBalanceResponse> replenishBalance(
            @RequestBody ReplenishBalanceRequest replenishBalanceRequest
    ) {
        return ResponseEntity.ok(cardService.replenishBalance( replenishBalanceRequest));
    }

    @GetMapping("/balance")
    public ResponseEntity<CheckBalanceResponse> checkBalance(
            @RequestBody CheckBalanceRequest checkBalanceRequest
    ) {
        return ResponseEntity.ok(cardService.checkBalance( checkBalanceRequest));
    }

    @GetMapping()
    public ResponseEntity<TakeMoneyResponse> takeMoney(
            @RequestBody TakeMoneyRequest takeMoneyRequest
    ) {
        return ResponseEntity.ok(cardService.takeMoney( takeMoneyRequest));
    }


    @PostMapping
    public ResponseEntity<TransferCashResponse> transferCash(
            @RequestBody TransferCashRequest transferCashRequest) {
        return ResponseEntity.ok(cardService.transferCash(transferCashRequest));
    }



}
