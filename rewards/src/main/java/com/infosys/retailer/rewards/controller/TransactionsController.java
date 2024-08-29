package com.infosys.retailer.rewards.controller;

import com.infosys.retailer.rewards.model.Transaction;
import com.infosys.retailer.rewards.service.RewardsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    private final RewardsService rewardsService;

    public TransactionsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @PostMapping
    private String addTransaction(@RequestBody Transaction transaction) {
        int points = rewardsService.calculateRewardPoints(transaction.getAmount());
        return "You have earned " + points + " points";
    }

    @GetMapping("/customer/{customerId}")
    public List<Transaction> getTransactionsByCustomerId(@PathVariable Long customerId) {
        return rewardsService.getTransactionsByCustomer(customerId);
    }

    @GetMapping("/monthly/{customerId}")
    public String getMonthlyPoints(@PathVariable Long customerId) {
        return "Monthly points for customer: " + rewardsService.getMonthlyPoints(customerId);
    }

    @GetMapping("/total/{customerId}")
    public String getTotalPoints(@PathVariable Long customerId) {
        return "Total points for customer: " + rewardsService.getTotalPoints(customerId);
    }
}
