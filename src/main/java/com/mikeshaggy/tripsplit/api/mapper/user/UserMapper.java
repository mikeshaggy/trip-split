package com.mikeshaggy.tripsplit.api.mapper.user;

import com.mikeshaggy.tripsplit.api.dto.user.UserDTO;
import com.mikeshaggy.tripsplit.api.mapper.BaseMapper;
import com.mikeshaggy.tripsplit.dao.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDTO> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Override
    User toEntity(UserDTO dto);

    @Override
    UserDTO toDto(User entity);
}
