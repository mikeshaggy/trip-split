package com.mikeshaggy.tripsplit.api.mapper.trip;

import com.mikeshaggy.tripsplit.api.dto.trip.TripDTO;
import com.mikeshaggy.tripsplit.api.mapper.BaseMapper;
import com.mikeshaggy.tripsplit.dao.trip.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TripMapper extends BaseMapper<Trip, TripDTO> {

    TripMapper INSTANCE = Mappers.getMapper(TripMapper.class);

    @Override
    Trip toEntity(TripDTO dto);

    @Override
    TripDTO toDto(Trip entity);
}
