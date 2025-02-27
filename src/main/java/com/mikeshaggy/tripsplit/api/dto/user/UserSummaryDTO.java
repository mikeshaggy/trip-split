package com.mikeshaggy.tripsplit.api.dto.user;

import com.mikeshaggy.tripsplit.api.dto.BaseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserSummaryDTO extends BaseDTO<UUID> {

    @Builder
    public UserSummaryDTO(UUID id, String name) {
        super(id);
        this.name = name;
    }

    private String name;
}
