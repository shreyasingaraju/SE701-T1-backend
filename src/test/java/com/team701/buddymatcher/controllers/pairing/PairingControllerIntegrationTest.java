package com.team701.buddymatcher.controllers.pairing;

import com.team701.buddymatcher.domain.users.Buddies;
import com.team701.buddymatcher.domain.users.User;
import com.team701.buddymatcher.dtos.pairing.AddBuddyDTO;
import com.team701.buddymatcher.dtos.pairing.RemoveBuddyDTO;
import com.team701.buddymatcher.repositories.users.UserRepository;
import com.team701.buddymatcher.services.pairing.PairingService;
import com.team701.buddymatcher.services.users.UserService;
import com.team701.buddymatcher.services.users.UserServiceImplUnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class PairingControllerIntegrationTest {

    @Mock
    private PairingService pairingService;

    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PairingController pairingController;


    @Test
    void addValidNewBuddy() {
        String userId = UUID.randomUUID().toString();
        String buddyId = UUID.randomUUID().toString();

        AddBuddyDTO buddyRequest = createMockedAddBuddyDTO(userId, buddyId);

        ResponseEntity response = pairingController.addBuddy(buddyRequest);

        //Temp response
        String success = String.format("\"Success: %s, %s \"", userId, buddyId);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), success);
    }

    AddBuddyDTO createMockedAddBuddyDTO(String userId, String buddyId) {
        var dto = new AddBuddyDTO();
        dto.setUserId(userId);
        dto.setBuddyId(buddyId);
        return dto;
    }

    @Test 
    void removeValidBuddy() {
    /*
        String userId = UUID.randomUUID().toString();
        String bud1Id = UUID.randomUUID().toString();
        String bud2Id = UUID.randomUUID().toString();
        String bud3Id = UUID.randomUUID().toString();

        RemoveBuddyDTO buddyRequest = createMockedRemoveBuddyDTO(userId, bud2Id);

        ResponseEntity response = pairingController.removeBuddy(buddyRequest);

        User user = new User();
        Buddies buddies = new Buddies();
        List<User> buddyList = new ArrayList<>();
        User bud1 = new User();
        User bud2 = new User();
        User bud3 = new User();

        user.setId(UUID.fromString(userId));
        bud1.setId(UUID.fromString(bud2Id));
        bud2.setId(UUID.fromString(bud2Id));
        bud3.setId(UUID.fromString(bud3Id));

        buddyList.add(bud1);
        buddyList.add(bud2);
        buddyList.add(bud3);

        buddies.setUsers(buddyList);
        user.setBuddies(buddies);


        // Set up mock UserService calls
        Mockito.when(userService.retrieve(userId)).thenReturn(user);
        Mockito.when(userService.retrieve(bud1Id)).thenReturn(bud1);
        Mockito.when(userService.retrieve(bud2Id)).thenReturn(bud2);
        Mockito.when(userService.retrieve(bud3Id)).thenReturn(bud3);

        pairingService.removeBuddy(userId, bud2Id);

        user = userService.retrieve(userId);
        bud2 = userService.retrieve(bud2Id);

        Assertions.assertEquals(2, user.getBuddies().getUsers().size());
        //Assertions.assertEquals(2, bud2.getBuddies().getUsers().size());

        //Temp response
        String success = String.format("\"Successfully Removed: %s, %s \"", userId, bud2Id);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), success);
 */
}

    RemoveBuddyDTO createMockedRemoveBuddyDTO(String userId, String buddyId) {
        var dto = new RemoveBuddyDTO();
        dto.setUserId(userId);
        dto.setBuddyId(buddyId);
        return dto;
    }
}
