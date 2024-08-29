package com.infosys.retailer.rewards.service;

import com.infosys.retailer.rewards.model.Transaction;
import com.infosys.retailer.rewards.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RewardsService {

    private final TransactionRepository transactionRepository;

    public RewardsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public int calculateRewardPoints(double amount) {
        int points = 0;
        if (amount>100) {
            points += (int) ((amount - 100) * 2 + 50);
        }
        else if (amount>50) {
            points += (int) (amount-50);
        }
        return points;
    }

    public List<Transaction> getTransactionsByCustomer(Long customerId) {
        // Retrieve transactions from the repository
        return transactionRepository.findByCustomerId(customerId);
    }

    public int getMonthlyPoints(Long customerId) {
        LocalDate startDate = LocalDate.now().withDayOfMonth(1); // First day of the current month
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth()); // Last day of the current month
        List<Transaction> transactions = transactionRepository.findByCustomerIdAndDateBetween(customerId, startDate, endDate);
        return transactions.stream()
                .mapToInt(transaction -> calculateRewardPoints(transaction.getAmount()))
                .sum();
    }

    public int getTotalPoints(Long customerId) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        return transactions.stream()
                .mapToInt(transaction -> calculateRewardPoints(transaction.getAmount()))
                .sum();
    }

}
