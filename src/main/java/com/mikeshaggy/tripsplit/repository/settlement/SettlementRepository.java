package com.mikeshaggy.tripsplit.repository.settlement;

import com.mikeshaggy.tripsplit.dao.settlement.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SettlementRepository extends JpaRepository<Settlement, UUID> {
}
