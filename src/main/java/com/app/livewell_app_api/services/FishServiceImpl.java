package com.app.livewell_app_api.services;

import com.app.livewell_app_api.repositories.FishRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishServiceImpl implements FishService {
    @Autowired
    private FishRepository fishRepository; 

    @Override
    public void deleteById(Long id){
        fishRepository.deleteById(id);
    }

    @Override
    public void deleteAll(){
        fishRepository.deleteAll();
    }
}
