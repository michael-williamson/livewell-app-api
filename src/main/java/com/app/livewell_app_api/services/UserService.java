package com.app.livewell_app_api.services;

import java.util.List;

import com.app.livewell_app_api.models.Fish;
import com.app.livewell_app_api.models.User;

public interface UserService {
    public User findByAuthId(String theId); 

    public User save(User user); 

    public List<Fish> getFish(User user);
}
