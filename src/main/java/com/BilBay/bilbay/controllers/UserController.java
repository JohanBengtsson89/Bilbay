package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Role;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.RoleRepository;
import com.BilBay.bilbay.repositories.UserRepository;
import com.BilBay.bilbay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/")
public class UserController extends Exception{
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @PostMapping(value = "addUser")
//    User addUser(@RequestBody User user) {
//            return userService.addUser(user);
//    }

    @GetMapping("auth/getUsers")
    @PreAuthorize("hasRole('ADMIN')")
    List<User> getUsers() {
        return userService.getUsers();
    }

//    @GetMapping("{email}/{pass}")
//    String loginUser(@PathVariable("email") String email,
//                   @PathVariable("pass") String password) {
//        try {
//            return userService.loginUser(email, password);
//        }
//        catch (Exception e) {
//            return e.toString();
//        }
//    }


//    (@PathVariable("email") String email,
//    @PathVariable("typeUser") TypeUser typeUser) {

//    @PutMapping("changeRole")
//    User changeUserType(@RequestBody Map<String, Object> payload) {
//        String email = (String) payload.get("emailAddress");
//        Set<Role> roles = new HashSet<>((List<Role>) payload.get("roles"));
//        return userService.changeUserType(email, roles);
//    }
}
