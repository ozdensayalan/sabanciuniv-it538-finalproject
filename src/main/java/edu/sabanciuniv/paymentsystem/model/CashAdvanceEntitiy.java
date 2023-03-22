package edu.sabanciuniv.paymentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CashAdvanceEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardNumber;
    private Integer amount;
    private Date registerDate;
    public boolean validateAmount(Integer amount) {//1 +1500
        if (amount >= 5 &&  amount <= 1500) return true;
        return false;
    }
}
