package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.TypeUser;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/user/")
public class UserController extends Exception{
    @Autowired
    private UserService userService;

    @PostMapping(value = "addUser")
    User addUser(@RequestBody User user) {
            return userService.addUser(user);
    }

    @GetMapping("getUsers")
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{email}/{pass}")
    String loginUser(@PathVariable("email") String email,
                   @PathVariable("pass") String password) {
        try {
            return userService.loginUser(email, password);
        }
        catch (Exception e) {
            return e.toString();
        }
    }


//    (@PathVariable("email") String email,
//    @PathVariable("typeUser") TypeUser typeUser) {

    @PutMapping("typeUser")
    User changeUserType(@RequestBody String email, Set<TypeUser> typeUsers) {
        User user = userService.getUser(email);
        user.setTypeUsers(typeUsers);
        return userService.updateUser(user);
//        return userService.getUser(user.getEmailAddress());
    }
}
