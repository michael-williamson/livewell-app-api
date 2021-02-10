package com.app.livewell_app_api.repositories;

import com.app.livewell_app_api.models.Fish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends JpaRepository<Fish,Long> {
    
}
