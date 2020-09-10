package com.example.easyapply.repositories;

import com.example.easyapply.entities.UserDetailsEntity;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<UserDetailsEntity> findUserByUserName(String userName);
}
