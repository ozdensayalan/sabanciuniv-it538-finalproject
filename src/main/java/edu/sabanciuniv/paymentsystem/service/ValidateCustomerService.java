package edu.sabanciuniv.paymentsystem.service;

import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import edu.sabanciuniv.paymentsystem.repository.CreditCardRepository;
import edu.sabanciuniv.paymentsystem.repository.ValidateCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@RequiredArgsConstructor
public class ValidateCustomerService {

    private final ValidateCustomerRepository validateCustomerRepository;
    public String validateCustomer(Long cardNumber,Integer password) {
        CreditCardEntity creditCardEntity = validateCustomerRepository.findCustomerByPassword(cardNumber,password);
        if(creditCardEntity!=null) {
            return "You have successfully logged in";
        }else {
            return "Please check your credit card and password!";
        }
    }
}
