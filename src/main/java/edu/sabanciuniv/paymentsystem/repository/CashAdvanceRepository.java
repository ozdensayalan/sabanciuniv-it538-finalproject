package edu.sabanciuniv.paymentsystem.repository;

import edu.sabanciuniv.paymentsystem.model.CashAdvanceEntitiy;
import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashAdvanceRepository extends JpaRepository<CashAdvanceEntitiy, Long> {
}

