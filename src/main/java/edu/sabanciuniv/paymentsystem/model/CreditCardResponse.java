package edu.sabanciuniv.paymentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardResponse {

    private Long cardNumber;
    private Integer password;
    private java.time.LocalDate expDate;
}
