package com.mikeshaggy.tripsplit.api.mapper;

public interface BaseMapper<E, D> {

    E toEntity(D dto);
    D toDto(E entity);
}
