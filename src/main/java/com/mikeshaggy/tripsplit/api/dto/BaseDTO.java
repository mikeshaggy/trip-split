package com.mikeshaggy.tripsplit.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class BaseDTO<ID> {
    private ID id;
}
