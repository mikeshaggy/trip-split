package com.mikeshaggy.tripsplit.dao.expense;

import com.mikeshaggy.tripsplit.dao.BaseEntity;
import com.mikeshaggy.tripsplit.dao.trip.Trip;
import com.mikeshaggy.tripsplit.dao.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "expenses")
@Getter
@Setter
public class Expense extends BaseEntity<UUID> {

    private BigDecimal amount;

    private String description;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
