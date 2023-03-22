package edu.sabanciuniv.paymentsystem.service;

import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import edu.sabanciuniv.paymentsystem.model.CreditCardResponse;
import edu.sabanciuniv.paymentsystem.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardResponse saveCreditCard(CreditCardEntity creditCardEntity) {
        Random rm = new Random();
        creditCardEntity.setCardNumber(rm.nextLong(1000000000000000L,9999999999999999L));
        creditCardEntity.setPassword(rm.nextInt(1000,9999));

        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, 3);
        DateFormat dt  = new SimpleDateFormat("yyyy/MM/dd");

        LocalDate date = LocalDate.now();
        date.plusYears(3);

        creditCardEntity.setExpDate(date);
        CreditCardResponse creditCardResponse =new  CreditCardResponse();
        if(creditCardEntity.validateIdentityNo(creditCardEntity.getIdentityNumber())) {

            CreditCardEntity creditCardEntity1=creditCardRepository.save(creditCardEntity.builder()
                    .firstname(creditCardEntity.getFirstname())
                    .lastname(creditCardEntity.getLastname())
                    .identityNumber(creditCardEntity.getIdentityNumber())
                    .cardNumber(creditCardEntity.getCardNumber())
                    .password(creditCardEntity.getPassword())
                    .expDate(creditCardEntity.getExpDate())
                    .build()) ;
             creditCardResponse = CreditCardResponse
                    .builder()
                    .cardNumber(creditCardEntity1.getCardNumber())
                    .password(creditCardEntity1.getPassword())
                    .expDate(creditCardEntity1.getExpDate())
                    .build();
            return creditCardResponse;
            }
        return creditCardResponse;
        }
}
