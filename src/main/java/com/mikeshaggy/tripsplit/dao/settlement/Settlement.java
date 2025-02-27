package com.mikeshaggy.tripsplit.dao.settlement;

import com.mikeshaggy.tripsplit.dao.BaseEntity;
import com.mikeshaggy.tripsplit.dao.trip.Trip;
import com.mikeshaggy.tripsplit.dao.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "settlements")
@Getter
@Setter
public class Settlement extends BaseEntity<UUID> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_id")
    private User payer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private BigDecimal amount;
}
