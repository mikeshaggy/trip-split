package com.mikeshaggy.tripsplit.dao.trip;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mikeshaggy.tripsplit.dao.BaseEntity;
import com.mikeshaggy.tripsplit.dao.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "trips")
@Getter
@Setter
@ToString
public class Trip extends BaseEntity<UUID> {

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private final LocalDateTime createdAt;

    public Trip() {
        this.createdAt = LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(
            name = "trip_participants",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private Set<User> participants;
}
