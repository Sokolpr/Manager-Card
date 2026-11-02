package peanutsh.cardservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peanutsh.cardservice.model.dto.request.*;
import peanutsh.cardservice.model.dto.response.*;
import peanutsh.cardservice.repository.CardRepository;
import peanutsh.cardservice.repository.UserRepository;
import peanutsh.cardservice.service.CardService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public ReplenishBalanceResponse replenishBalance( ReplenishBalanceRequest replenishBalanceRequest) {
        return null;
    }

    @Override
    public CheckBalanceResponse checkBalance( CheckBalanceRequest checkBalanceRequest) {
        return null;
    }

    @Override
    public TakeMoneyResponse takeMoney(TakeMoneyRequest replenishBalanceRequest) {
        return null;
    }

    @Override
    public TransferCashResponse transferCash(TransferCashRequest transferCashRequest) {
        return null;
    }
}
