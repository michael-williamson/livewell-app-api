package com.app.livewell_app_api.services;

import java.util.List;

import com.app.livewell_app_api.models.Fish;
import com.app.livewell_app_api.models.User;
import com.app.livewell_app_api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository; 

    @Override
	public User findByAuthId(String theId) {
         User user = userRepository.findByAuthId(theId);
         if(user == null){
            return null; 
         }
         return user; 
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);   
    }

    @Override
    public List<Fish> getFish(User user){
        return user.getFish(); 
    }
}
