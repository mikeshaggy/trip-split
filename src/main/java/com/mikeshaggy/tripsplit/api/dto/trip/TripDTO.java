package com.mikeshaggy.tripsplit.api.dto.trip;

import com.mikeshaggy.tripsplit.api.dto.BaseDTO;
import com.mikeshaggy.tripsplit.api.dto.user.UserSummaryDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class TripDTO extends BaseDTO<UUID> {

    @Builder
    public TripDTO(UUID id, String name, LocalDate startDate, LocalDate endDate, LocalDateTime createdAt, Set<UserSummaryDTO> participants) {
        super(id);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.participants = participants;
    }

    @NotNull(message = "Trip's name cannot be null")
    private String name;

    @NotNull(message = "Trip's start date cannot be null")
    private LocalDate startDate;

    @NotNull(message = "Trip's end date cannot be null")
    private LocalDate endDate;

    private LocalDateTime createdAt;

    private Set<UserSummaryDTO> participants;

    @Override
    public String toString() {
        return "TripDTO{" + "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createdAt=" + createdAt +
                ", participants=" + participants +
                '}';
    }
}
