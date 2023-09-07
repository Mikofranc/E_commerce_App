package org.example.service;

import org.example.data.model.Roles;
import org.example.data.model.User;
import org.example.data.repo.UserRepo;
import org.example.dto.UserRequest;
import org.example.utility.Checker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public void registerNewUser(UserRequest request){
        User user = new User();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        user.setUserName(request.getUserName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        request.setRoles(Roles.DEFAULT);
        user.setRoles(request.getRoles());
        user.setCreatedDate(LocalDateTime.now().format(formatter));
        user.setRoles(request.getRoles());
//        Checker.usernameAndPassword(user.getUserName(), user.getPassword());
//        Checker.checkStringInput(user.getFirstName());
//        Checker.checkStringInput(user.getLastName());
        userRepo.save(user);
    }

    @Override
    public Optional<User> login(UserRequest request) {
        var  user =userRepo.findByUserName(request.getUserName());
        if(user.isPresent()){
            var verifiedUser = user.get();
            if(verifiedUser.getPassword().equals(request.getPassword())){
                return user;
            }
        }
        return user;
    }


}
