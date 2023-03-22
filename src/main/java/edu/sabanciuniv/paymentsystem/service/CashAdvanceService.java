package edu.sabanciuniv.paymentsystem.service;

import edu.sabanciuniv.paymentsystem.model.CashAdvanceEntitiy;
import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import edu.sabanciuniv.paymentsystem.repository.CashAdvanceRepository;
import edu.sabanciuniv.paymentsystem.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
@Service
@RequiredArgsConstructor
public class CashAdvanceService {

    private final CashAdvanceRepository cashAdvanceRepository;
    public String saveCashAdvance(CashAdvanceEntitiy cashAdvanceEntitiy) {
        cashAdvanceEntitiy.setRegisterDate(new Date());
        if(cashAdvanceEntitiy.validateAmount(cashAdvanceEntitiy.getAmount())) {
             cashAdvanceRepository.save(cashAdvanceEntitiy.builder()
                    .cardNumber(cashAdvanceEntitiy.getCardNumber())
                    .amount(cashAdvanceEntitiy.getAmount())
                    .registerDate(cashAdvanceEntitiy.getRegisterDate())
                    .build()).getCardNumber();
             return "Your transaction has been successfully completed.";
        }
        return "Please double check the amount you entered.!";
    }
}
