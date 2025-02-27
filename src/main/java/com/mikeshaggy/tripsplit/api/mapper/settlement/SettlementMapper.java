package com.mikeshaggy.tripsplit.api.mapper.settlement;

import com.mikeshaggy.tripsplit.api.dto.settlement.SettlementDTO;
import com.mikeshaggy.tripsplit.api.mapper.BaseMapper;
import com.mikeshaggy.tripsplit.dao.settlement.Settlement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SettlementMapper extends BaseMapper<Settlement, SettlementDTO> {

    SettlementMapper INSTANCE = Mappers.getMapper(SettlementMapper.class);

    @Override
    Settlement toEntity(SettlementDTO dto);

    @Override
    SettlementDTO toDto(Settlement entity);
}
