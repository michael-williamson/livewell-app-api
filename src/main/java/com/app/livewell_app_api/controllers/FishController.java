package com.app.livewell_app_api.controllers;

import java.security.Principal;
import java.util.List;

import com.app.livewell_app_api.models.Fish;
import com.app.livewell_app_api.models.User;
import com.app.livewell_app_api.services.FishService;
import com.app.livewell_app_api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "api/authorize", produces = MediaType.APPLICATION_JSON_VALUE)
public class FishController {

    @Autowired
    private UserService userService; 

    @Autowired
    private FishService fishService; 

    @CrossOrigin("http://localhost:3000")
    @GetMapping(value = "/fish")
    public List<Fish> getUserFish(Principal principal){
        User user = userService.findByAuthId(principal.getName());
        if(user == null){
            User newUser = new User(); 
            newUser.setAuthId(principal.getName());  
            userService.save(newUser);   
            return newUser.getFish(); 
        }  
        return userService.getFish(user);
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping(value="/fish")
    public List<Fish> addFish(@RequestBody Fish fish, Principal principal){
        User userInstance = userService.findByAuthId(principal.getName());
        userInstance.addFish(fish);
        userService.save(userInstance);
        return userInstance.getFish(); 
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping(value={"/fish","/fish/{id}"})
    public List<Fish> deleteFish(@PathVariable(required = false) Long id,Principal principal){

        if(id < 0){
            fishService.deleteAll();
        }else{
            fishService.deleteById(id);
        }
        User userInstance = userService.findByAuthId(principal.getName());
        return userInstance.getFish(); 

    }
}
