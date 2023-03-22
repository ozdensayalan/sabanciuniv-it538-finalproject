package edu.sabanciuniv.paymentsystem.service;

import edu.sabanciuniv.paymentsystem.model.CashAdvanceEntitiy;
import edu.sabanciuniv.paymentsystem.model.CreditCardEntity;
import edu.sabanciuniv.paymentsystem.repository.CashAdvanceRepository;
import edu.sabanciuniv.paymentsystem.repository.CreditCardRepository;
import edu.sabanciuniv.paymentsystem.repository.ValidateCustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceTest {
    @InjectMocks
    CreditCardService creditCardService;
    @Mock
    CreditCardRepository creditCardRepository;

    @InjectMocks
    CashAdvanceService cashAdvanceService;
    @Mock
    CashAdvanceRepository cashAdvanceRepository;

    @InjectMocks
    ValidateCustomerService validateCustomerService;
    @Mock
    ValidateCustomerRepository validateCustomerRepository;
    @Test
    void validateIdentityNo() {
        CreditCardEntity cc=new CreditCardEntity();
        assertEquals(cc.validateIdentityNo(9999999999L),false);
        assertEquals(cc.validateIdentityNo(10000000000L),true);
        assertEquals(cc.validateIdentityNo(10000000001L),true);
        assertEquals(cc.validateIdentityNo(54372817053L),true);
        assertEquals(cc.validateIdentityNo(99999999998L),true);
        assertEquals(cc.validateIdentityNo(99999999999L),true);
        assertEquals(cc.validateIdentityNo(100000000000L),false);
    }
    @Test
    void validateCashAdvance() {
        CashAdvanceEntitiy ca=new CashAdvanceEntitiy();
        assertEquals(ca.validateAmount(4),false);
        assertEquals(ca.validateAmount(5),true);
        assertEquals(ca.validateAmount(6),true);
        assertEquals(ca.validateAmount(1000),true);
        assertEquals(ca.validateAmount(1499),true);
        assertEquals(ca.validateAmount(1500),true);
        assertEquals(ca.validateAmount(1501),false);

    }
}
