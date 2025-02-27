package com.mikeshaggy.tripsplit.service.expense;

import com.mikeshaggy.tripsplit.api.dto.expense.ExpenseDTO;
import com.mikeshaggy.tripsplit.api.mapper.expense.ExpenseMapper;
import com.mikeshaggy.tripsplit.dao.expense.Expense;
import com.mikeshaggy.tripsplit.repository.expense.ExpenseRepository;
import com.mikeshaggy.tripsplit.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExpenseService extends BaseService<
        Expense,
        UUID,
        ExpenseDTO,
        ExpenseRepository,
        ExpenseMapper> {

    public ExpenseService(ExpenseRepository nativeRepository, ExpenseMapper nativeMapper) {
        super(nativeRepository, nativeMapper);
    }
}
