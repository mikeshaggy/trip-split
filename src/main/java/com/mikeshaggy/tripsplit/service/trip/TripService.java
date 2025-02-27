package com.mikeshaggy.tripsplit.service.trip;

import com.mikeshaggy.tripsplit.api.dto.trip.TripDTO;
import com.mikeshaggy.tripsplit.api.dto.user.UserDTO;
import com.mikeshaggy.tripsplit.api.mapper.trip.TripMapper;
import com.mikeshaggy.tripsplit.api.rest.exception.ParticipantAlreadyAddedException;
import com.mikeshaggy.tripsplit.dao.trip.Trip;
import com.mikeshaggy.tripsplit.dao.user.User;
import com.mikeshaggy.tripsplit.repository.trip.TripRepository;
import com.mikeshaggy.tripsplit.service.BaseService;
import com.mikeshaggy.tripsplit.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TripService extends BaseService<
        Trip,
        UUID,
        TripDTO,
        TripRepository,
        TripMapper> {

    private final UserService userService;

    public TripService(TripRepository nativeRepository, TripMapper nativeMapper, UserService userService) {
        super(nativeRepository, nativeMapper);
        this.userService = userService;
    }

    public TripDTO addParticipantToTrip(UUID tripId, UUID participantId) {
        Trip trip = getEntityById(tripId);
        User participant = userService.getEntityById(participantId);

        if (participant.getTrips().contains(trip)) {
            throw new ParticipantAlreadyAddedException(
                    String.format("%s is already a participant in %s trip",
                            participant.getName(), trip.getName()));
        }

        trip.getParticipants().add(participant);

        nativeRepository.save(trip);

        return nativeMapper.toDto(trip);
    }

}
