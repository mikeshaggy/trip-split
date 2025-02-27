package com.mikeshaggy.tripsplit.api.rest.controller.trip;

import com.mikeshaggy.tripsplit.api.dto.trip.TripDTO;
import com.mikeshaggy.tripsplit.service.trip.TripService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(TripController.BASE_URL)
public class TripController {

    public static final String BASE_URL = "/api/trips";

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<List<TripDTO>> getAllTrips() {
        return new ResponseEntity<>(tripService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDTO> getTripById(
            @PathVariable UUID id) {
        return new ResponseEntity<>(tripService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TripDTO> createNewTrip(
            @Valid @RequestBody TripDTO tripDTO) {
        return new ResponseEntity<>(tripService.create(tripDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripDTO> updateTrip(
            @PathVariable UUID id,
            @Valid @RequestBody TripDTO tripDTO) {
        return new ResponseEntity<>(tripService.update(id, tripDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTripById(
            @PathVariable UUID id) {
        tripService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
