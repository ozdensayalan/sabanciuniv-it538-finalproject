package edu.sabanciuniv.paymentsystem.controller;

import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import edu.sabanciuniv.paymentsystem.model.CreditCardResponse;
import edu.sabanciuniv.paymentsystem.service.CreditCardService;
import edu.sabanciuniv.paymentsystem.service.ValidateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ValidateCustomerController {
    private final ValidateCustomerService validateCustomerService;
    @GetMapping("/validateCustomer")
    public String saveCustomer(@RequestBody CreditCardEntity creditCard) {
        return validateCustomerService.validateCustomer(creditCard.getCardNumber(),creditCard.getPassword());
    }
}
