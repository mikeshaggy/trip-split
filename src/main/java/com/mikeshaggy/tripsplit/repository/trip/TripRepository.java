package com.mikeshaggy.tripsplit.repository.trip;

import com.mikeshaggy.tripsplit.dao.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
}
