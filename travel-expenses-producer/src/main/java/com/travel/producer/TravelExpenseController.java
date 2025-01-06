package com.travel.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelExpenseController {

    private final TravelExpenseService travelExpenseService;

    @Autowired
    public TravelExpenseController(TravelExpenseService travelExpenseService) {
        this.travelExpenseService = travelExpenseService;
    }

    @PostMapping("/submit-expense")
    public String submitExpense(@RequestParam String expenseDetails) {
        travelExpenseService.submitExpenseRequest(expenseDetails);
        return "Expense request submitted!";
    }
}

