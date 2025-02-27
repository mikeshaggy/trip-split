package com.mikeshaggy.tripsplit.dao.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mikeshaggy.tripsplit.dao.BaseEntity;
import com.mikeshaggy.tripsplit.dao.trip.Trip;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity<UUID> {

    private String name;

    private String email;

    private final LocalDateTime createdAt;

    public User() {
        this.createdAt = LocalDateTime.now();
    }

    @ManyToMany(mappedBy = "participants")
    Set<Trip> trips;
}
