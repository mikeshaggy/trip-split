package com.mikeshaggy.tripsplit.api.mapper.expense;

import com.mikeshaggy.tripsplit.api.dto.expense.ExpenseDTO;
import com.mikeshaggy.tripsplit.api.mapper.BaseMapper;
import com.mikeshaggy.tripsplit.dao.expense.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseMapper extends BaseMapper<Expense, ExpenseDTO> {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    @Override
    Expense toEntity(ExpenseDTO dto);

    @Override
    ExpenseDTO toDto(Expense entity);
}
