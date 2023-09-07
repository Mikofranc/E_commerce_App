package org.example.service;

import org.example.data.repo.AdminRepo;
import org.example.dto.AdminRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import  static org.hamcrest.CoreMatchers.is;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepo adminRepo;
    @Test
    public void testToAddAmin(){
        AdminRequest request = new AdminRequest();
        request.setPassword("12345");
        request.setFirstName("Josh");
        request.setLastName("Ayomide");
        request.setUserName("josh123");
        adminService.registerNewUser(request);
        assertThat(adminRepo.count(),is(3L));
    }
    @Test
    public void testToMultipleAddAmin(){
        AdminRequest request = new AdminRequest();
        request.setPassword("12345");
        request.setFirstName("Josh");
        request.setLastName("Ayomide");
        request.setUserName("josh12");
        adminService.registerNewUser(request);

        AdminRequest request1 = new AdminRequest();
        request1.setPassword("12345");
        request1.setFirstName("Josh");
        request1.setLastName("Ayomide");
        request1.setUserName("josh128");
        adminService.registerNewUser(request1);
        assertThat(adminRepo.count(),is(3L));
    }
    @Test
    public void testThatUserCanLogin(){
        AdminRequest request = new AdminRequest();
        request.setPassword("12345");
        request.setUserName("josh12");
        var user =adminService.login(request);
        assertThat(user.getFirstName(),is("Josh"));
    }
}