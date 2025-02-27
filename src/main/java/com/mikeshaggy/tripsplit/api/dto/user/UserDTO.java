package com.mikeshaggy.tripsplit.api.dto.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mikeshaggy.tripsplit.api.dto.BaseDTO;
import com.mikeshaggy.tripsplit.api.dto.trip.TripDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class UserDTO extends BaseDTO<UUID> {

    @Builder
    public UserDTO(UUID id, String name, String email, LocalDateTime createdAt, Set<TripDTO> trips) {
        super(id);
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.trips = trips;
    }

    @NotNull(message = "User's name cannot be null")
    private String name;

    private String email;

    private LocalDateTime createdAt;

    @JsonIgnore
    private Set<TripDTO> trips;
}
