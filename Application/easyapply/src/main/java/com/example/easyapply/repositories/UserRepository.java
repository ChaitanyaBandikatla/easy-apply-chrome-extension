package com.example.easyapply.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.easyapply.entities.UserDetailsEntity;


public interface UserRepository extends JpaRepository<UserDetailsEntity, Integer>, UserRepositoryCustom {
}
