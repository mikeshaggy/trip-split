package com.mikeshaggy.tripsplit.repository.user;

import com.mikeshaggy.tripsplit.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
