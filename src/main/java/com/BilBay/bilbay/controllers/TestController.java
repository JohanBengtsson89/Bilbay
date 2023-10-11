package com.BilBay.bilbay.controllers;


import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.ERole;
import com.BilBay.bilbay.models.Role;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.payload.requests.LoginRequest;
import com.BilBay.bilbay.payload.requests.SignupRequest;
import com.BilBay.bilbay.payload.response.MessageResponse;
import com.BilBay.bilbay.payload.response.UserInfoResponse;
import com.BilBay.bilbay.repositories.RoleRepository;
import com.BilBay.bilbay.repositories.UserRepository;
import com.BilBay.bilbay.security.jwt.JwtUtils;
import com.BilBay.bilbay.security.services.UserDetailsImpl;
import com.BilBay.bilbay.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

//    @Autowired
//    TodoRepository todoRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/private")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String userAccess() {
        return "Private Content.";
    }

    @GetMapping("/company")
    @PreAuthorize("hasRole('COMPANY')")
    public String companyAccess() {
        return "Company Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("user/{id}")
    public User findUserById (@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getEmail(),
                        roles, userDetails.getUsername()));
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByUsername((signupRequest.getUsername()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // create new users account
        User user = new User(signupRequest.getFirstName(),signupRequest.getLastName(), signupRequest.getEmail(),signupRequest.getUsername(),
                encoder.encode(signupRequest.getPassword()),signupRequest.getCompanyName(), signupRequest.getOrganizationNumber());

        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role privateRole = roleRepository.findByName(ERole.ROLE_PRIVATE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(privateRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "company":
                        Role companyRole = roleRepository.findByName(ERole.ROLE_COMPANY)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(companyRole);
                        break;
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(adminRole);
                        break;
                    default:
                        Role privateRole = roleRepository.findByName(ERole.ROLE_PRIVATE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(privateRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }

    @PutMapping("users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Valid @RequestBody User updateUser) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: User not found!"));
        }

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: User not found!"));

        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setEmail(updateUser.getEmail());
        user.setUsername(updateUser.getUsername());
        user.setCompanyName(updateUser.getCompanyName());
        user.setOrganizationNumber(updateUser.getOrganizationNumber());

        if (updateUser.getPassword() != null && !updateUser.getPassword().isEmpty()) {
            user.setPassword(encoder.encode(updateUser.getPassword()));
        }

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User updated successfully"));
    }
//    @PostMapping("/todo")
//    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
//        try {
//            Todo _todo = todoRepository.save(new Todo(todo.getTitle(), todo.getDescription()));
//            return new ResponseEntity<>(_todo, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/todo")
//    public List<Todo> getAllTodos() {
//        return todoRepository.findAll();
}