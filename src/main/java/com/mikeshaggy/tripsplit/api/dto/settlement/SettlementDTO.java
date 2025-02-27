package com.mikeshaggy.tripsplit.api.dto.settlement;

import com.mikeshaggy.tripsplit.api.dto.BaseDTO;
import com.mikeshaggy.tripsplit.api.dto.trip.TripDTO;
import com.mikeshaggy.tripsplit.api.dto.user.UserDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class SettlementDTO extends BaseDTO<UUID> {

    @Builder
    public SettlementDTO(UUID id, TripDTO trip, UserDTO payer, UserDTO receiver, BigDecimal amount) {
        super(id);
        this.trip = trip;
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
    }

    @NotNull(message = "Settlement needs to be associated with a Trip")
    private TripDTO trip;

    @NotNull(message = "Settlement needs to be associated with a User(Payer)")
    private UserDTO payer;

    @NotNull(message = "Settlement needs to be associated with a User(Receiver)")
    private UserDTO receiver;

    @NotNull(message = "Settlement's amount cannot be null")
    @Positive(message = "Settlement's amount needs to be a positive value")
    private BigDecimal amount;
}
