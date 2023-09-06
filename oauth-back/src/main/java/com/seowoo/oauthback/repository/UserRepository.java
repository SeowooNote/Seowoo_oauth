package com.seowoo.oauthback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seowoo.oauthback.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
     
     boolean existsById(String id);

}
