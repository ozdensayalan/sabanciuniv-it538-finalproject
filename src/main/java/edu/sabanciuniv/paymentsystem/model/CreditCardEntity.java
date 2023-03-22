package edu.sabanciuniv.paymentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.engine.jdbc.Size;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private Long identityNumber;
    private Long cardNumber;
    private Integer password;
    private java.time.LocalDate expDate;

    public boolean validateIdentityNo(Long identityNo) {//10000000000L 99999999999L
        if (identityNo >= 10000000000L &&  identityNo <= +99999999999L) return true;
        return false;
    }
}
