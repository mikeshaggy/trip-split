package com.mikeshaggy.tripsplit.api.rest.controller.expense;

import com.mikeshaggy.tripsplit.api.dto.expense.ExpenseDTO;
import com.mikeshaggy.tripsplit.service.expense.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ExpenseController.BASE_URL)
public class ExpenseController {

    public static final String BASE_URL = "/api/expenses";

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(
            @PathVariable UUID id) {
        return new ResponseEntity<>(expenseService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> createNewExpense(
            @Valid @RequestBody ExpenseDTO expenseDTO) {
        return new ResponseEntity<>(expenseService.create(expenseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(
            @PathVariable UUID id,
            @Valid @RequestBody ExpenseDTO expenseDTO) {
        return new ResponseEntity<>(expenseService.update(id, expenseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseById(
            @PathVariable UUID id) {
        expenseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
