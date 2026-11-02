package peanutsh.cardservice.service;

import peanutsh.cardservice.model.dto.request.*;
import peanutsh.cardservice.model.dto.response.*;


public interface CardService {

     ReplenishBalanceResponse replenishBalance( ReplenishBalanceRequest replenishBalanceRequest);

     CheckBalanceResponse checkBalance( CheckBalanceRequest checkBalanceRequest);

     TakeMoneyResponse takeMoney(TakeMoneyRequest replenishBalanceRequest);

     TransferCashResponse transferCash( TransferCashRequest transferCashRequest);


}
