package com.mikeshaggy.tripsplit.service.trip;

import com.mikeshaggy.tripsplit.api.dto.trip.TripDTO;
import com.mikeshaggy.tripsplit.api.mapper.trip.TripMapper;
import com.mikeshaggy.tripsplit.dao.trip.Trip;
import com.mikeshaggy.tripsplit.repository.trip.TripRepository;
import com.mikeshaggy.tripsplit.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TripService extends BaseService<
        Trip,
        UUID,
        TripDTO,
        TripRepository,
        TripMapper> {

    public TripService(TripRepository nativeRepository, TripMapper nativeMapper, TripRepository tripRepository) {
        super(nativeRepository, nativeMapper);
    }

}
