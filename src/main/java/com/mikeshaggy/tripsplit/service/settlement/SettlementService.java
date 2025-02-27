package com.mikeshaggy.tripsplit.service.settlement;

import com.mikeshaggy.tripsplit.api.dto.settlement.SettlementDTO;
import com.mikeshaggy.tripsplit.api.mapper.settlement.SettlementMapper;
import com.mikeshaggy.tripsplit.dao.settlement.Settlement;
import com.mikeshaggy.tripsplit.repository.settlement.SettlementRepository;
import com.mikeshaggy.tripsplit.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SettlementService extends BaseService<
        Settlement,
        UUID,
        SettlementDTO,
        SettlementRepository,
        SettlementMapper> {

    public SettlementService(SettlementRepository nativeRepository, SettlementMapper nativeMapper) {
        super(nativeRepository, nativeMapper);
    }
}
