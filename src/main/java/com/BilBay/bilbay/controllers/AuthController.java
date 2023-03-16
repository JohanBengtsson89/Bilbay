package com.BilBay.bilbay.controllers;


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
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("signin")
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
                        roles));
    }

    @PostMapping("signup")
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
}
