package edu.sabanciuniv.paymentsystem.repository;

import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
}
