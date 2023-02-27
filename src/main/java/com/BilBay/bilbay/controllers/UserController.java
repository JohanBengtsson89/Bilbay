package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.models.UserType;
import com.BilBay.bilbay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PutMapping("{email}/{userType}")
    User changeUserType(@PathVariable("email") String email,
                          @PathVariable("userType") UserType userType) {
        User user = userService.getUser(email);
        user.setUserType(userType);
        return userService.getUser(user.getEmailAddress());
    }
}
