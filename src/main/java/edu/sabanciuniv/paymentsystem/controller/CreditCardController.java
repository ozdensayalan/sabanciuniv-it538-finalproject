package edu.sabanciuniv.paymentsystem.controller;

import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import edu.sabanciuniv.paymentsystem.model.CreditCardResponse;
import edu.sabanciuniv.paymentsystem.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreditCardController {
    private final CreditCardService creditCardService;
    @PostMapping("/registerCreditCard")
    public CreditCardResponse saveCustomer(@RequestBody CreditCardEntity creditCard) {
        return creditCardService.saveCreditCard(creditCard);
    }


}
