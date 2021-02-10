package com.app.livewell_app_api.repositories;

import com.app.livewell_app_api.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByAuthId(String authId);

}
