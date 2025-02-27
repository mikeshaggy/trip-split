package com.mikeshaggy.tripsplit.service.user;

import com.mikeshaggy.tripsplit.api.dto.user.UserDTO;
import com.mikeshaggy.tripsplit.api.mapper.user.UserMapper;
import com.mikeshaggy.tripsplit.dao.user.User;
import com.mikeshaggy.tripsplit.repository.user.UserRepository;
import com.mikeshaggy.tripsplit.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService extends BaseService<
        User,
        UUID,
        UserDTO,
        UserRepository,
        UserMapper> {

    public UserService(UserRepository nativeRepository, UserMapper nativeMapper) {
        super(nativeRepository, nativeMapper);
    }
}
