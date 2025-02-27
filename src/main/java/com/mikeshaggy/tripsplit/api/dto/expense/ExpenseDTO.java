package com.mikeshaggy.tripsplit.api.dto.expense;

import com.mikeshaggy.tripsplit.api.dto.BaseDTO;
import com.mikeshaggy.tripsplit.api.dto.trip.TripDTO;
import com.mikeshaggy.tripsplit.api.dto.user.UserDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ExpenseDTO extends BaseDTO<UUID> {

    @Builder
    public ExpenseDTO(UUID id, BigDecimal amount, String description, LocalDateTime createdAt, TripDTO trip, UserDTO user) {
        super(id);
        this.amount = amount;
        this.description = description;
        this.createdAt = createdAt;
        this.trip = trip;
        this.user = user;
    }

    @NotNull(message = "Expense's amount cannot be null")
    @Positive(message = "Expense's amount needs to be a positive value")
    private BigDecimal amount;

    @NotNull(message = "Expense's description cannot be null")
    private String description;

    private LocalDateTime createdAt;

    @NotNull(message = "Expense needs to be associated with a Trip")
    private TripDTO trip;

    @NotNull(message = "Expense needs to be associated with a User")
    private UserDTO user;
}
