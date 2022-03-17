package com.team701.buddymatcher.services.pairing.impl;

import com.team701.buddymatcher.domain.users.Buddies;
import com.team701.buddymatcher.domain.users.User;
import com.team701.buddymatcher.repositories.users.UserRepository;
import com.team701.buddymatcher.services.pairing.PairingService;
import org.springframework.stereotype.Service;

import  com.team701.buddymatcher.services.users.UserService;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation for the PairingService which is a service providing the implementations of the methods
 * for the pairing endpoints
 */
@Service
public class PairingServiceImpl implements PairingService {

    private final UserRepository userRepository;
    private final UserService userService;


    public PairingServiceImpl(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
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
        User buddy = userService.retrieve(buddyId);
        Buddies userBuddies = user.getBuddies();
        List<User> userBuddyList = userBuddies.getUsers();
        System.out.println("Before: " + userBuddyList.toString());
        userBuddyList.removeIf(currentUser -> currentUser.getId().toString().equals(buddyId));

        Buddies buddyBuddies = buddy.getBuddies();
        List<User> buddyBuddyList = buddyBuddies.getUsers();
        buddyBuddyList.removeIf(currentUser -> currentUser.getId().toString().equals(userId));

        userBuddies.setUsers(userBuddyList);
        user.setBuddies(userBuddies);

        buddyBuddies.setUsers(buddyBuddyList);
        buddy.setBuddies(buddyBuddies);

        // save the user back in the user repo - can we get a method in
        // UserService to do this instead ?
        userRepository.save(user);
        userRepository.save(buddy);


        System.out.println(String.format("Buddy remove request: %s, %s",user.getId(),buddyBuddies.getId()));
    }
}
