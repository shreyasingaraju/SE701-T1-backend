package com.team701.buddymatcher.services.pairing.impl;

import com.team701.buddymatcher.domain.users.Buddies;
import com.team701.buddymatcher.domain.users.User;
import com.team701.buddymatcher.services.pairing.PairingService;
import org.springframework.stereotype.Service;

import  com.team701.buddymatcher.services.users.impl.UserServiceImpl;

import java.util.List;


/**
 * Implementation for the PairingService which is a service providing the implementations of the methods
 * for the pairing endpoints
 */
@Service
public class PairingServiceImpl implements PairingService {

    private final UserServiceImpl userService;

    public PairingServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void addBuddy(String userId, String buddyId) {
        //Currently just a blank implementation for testing endpoint call
        System.out.println(String.format("Buddy add request: %s, %s",userId,buddyId));
    }
    
    @Override
    public void removeBuddy(String userId, String buddyId) {
        //Currently just a blank implementation for testing endpoint call
        User user = userService.retrieve(userId);
        Buddies userBuddies = user.getBuddies();
        List<User> userBuddyList = userBuddies.getUsers();
        userBuddyList.removeIf(u -> u.getId().toString().equals(buddyId));
        userBuddies.setUsers(userBuddyList);
        user.setBuddies(userBuddies);
        System.out.println(String.format("Buddy remove request: %s, %s",userId,buddyId));
    }
}
