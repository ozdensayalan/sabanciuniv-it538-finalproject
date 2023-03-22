package edu.sabanciuniv.paymentsystem.controller;

import edu.sabanciuniv.paymentsystem.model.CashAdvanceEntitiy;
import edu.sabanciuniv.paymentsystem.service.CashAdvanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CashAdvanceController {
    private final CashAdvanceService cashAdvanceService;
    @PostMapping("/withdrawCashAdvance")
    public String saveCashAdvance(@RequestBody CashAdvanceEntitiy cashAdvance) {
        return cashAdvanceService.saveCashAdvance(cashAdvance);
    }
}