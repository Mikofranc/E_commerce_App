package org.example.service;

import org.example.data.model.Roles;
import org.example.data.repo.UserRepo;
import org.example.dto.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Test
    public void testToRegisterUser(){
        UserRequest request = new UserRequest();
        request.setUserName("miko1234");
        request.setPassword("111");
        request.setFirstName("micheal");
        request.setLastName("Ayomide");
        userService.registerNewUser(request);
        assertEquals(3,userRepo.count());
    }
    @Test
    public void testToRegisterMultipleUser(){
        UserRequest request = new UserRequest();
        request.setUserName("miko123");
        request.setPassword("1234");
        request.setFirstName("micheal");
        request.setLastName("Ayomide");
        userService.registerNewUser(request);

        UserRequest request1 = new UserRequest();
        request1.setUserName("miko1233");
        request1.setPassword("1123");
        request1.setFirstName("micheal");
        request1.setLastName("Ayomide");
        userService.registerNewUser(request1);
        assertEquals(3,userRepo.count());
    }
    @Test
    public void testToLogin(){
        UserRequest request = new UserRequest();
        request.setUserName("miko123");
        request.setPassword("1234");
        request.setFirstName("micheal");
        request.setLastName("Ayomide");
        var result =userService.login(request);
        System.out.println(result.get().toString());
    }
//    @Test
//    public void testToLogin_wrongUser(){
//        UserRequest request = new UserRequest();
//        request.setUserName("miko1432");
//        request.setPassword("1234");
//        request.setFirstName("micheal");
//        request.setLastName("Ayomide");
//        assertThrows(userService.login(request),()->);
//    }


}