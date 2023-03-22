package edu.sabanciuniv.paymentsystem.repository;

import edu.sabanciuniv.paymentsystem.model.CashAdvanceEntitiy;
import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import edu.sabanciuniv.paymentsystem.service.ValidateCustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface ValidateCustomerRepository extends JpaRepository<CreditCardEntity, Long> {

    @Query("select cc from CreditCardEntity cc where cc.cardNumber =:cardNumber and cc.password=:password")
    CreditCardEntity findCustomerByPassword(Long cardNumber,Integer password);
}

