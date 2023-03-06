package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Role;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.RoleRepository;
import com.BilBay.bilbay.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public User addUser(User user) {
        Set<Role> roles = new HashSet<>();
        for (Role role : user.getRoles()) {
            Role existingRole = roleRepository.findByName(role.getName());
            if (existingRole != null) {
                roles.add(existingRole);
            }
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Kollar i repot efter en user med angiven email och password. Om det hittas en en user med det så säger den att
    // inloggningen lyckades, annars att email eller lösenord är felaktigt
    public String loginUser(String email, String password) {
        if (!userRepository.findByEmailAddressAndPasswordHash(email, password).isEmpty()) {
            return "Inloggning lyckades för användare med email " + email;
        }
        return "Du angav fel email eller lösenord.";
    }

    public User getUser(String email) {
        return userRepository.findUserByEmailAddress(email);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public User changeUserType(String email, Set<Role> roles) {
        User user = userRepository.findUserByEmailAddress(email);
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
