package com.mikeshaggy.tripsplit.repository.expense;

import com.mikeshaggy.tripsplit.dao.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
}
