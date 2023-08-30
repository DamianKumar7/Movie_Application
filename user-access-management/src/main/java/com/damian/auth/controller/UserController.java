package com.damian.auth.controller;


import com.damian.auth.DTO.LoginRequest;
import com.damian.auth.DTO.RegistrationRequest;
//import com.damian.auth.Util.JwtGeneratorUtil;
import com.damian.auth.model.User;
import com.damian.auth.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

//    @Autowired
//    JwtGeneratorUtil jwtGeneratorUtil;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        boolean successfulRegistration = userService.registerUser(registrationRequest);
        if (successfulRegistration) {
            return new ResponseEntity<>("User Created Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("User with this email already exists", HttpStatus.CONFLICT);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        User loggedInUser = userService.loginUser(loginRequest);
        if (loggedInUser != null) {
            String jwtToken = generateToken(loggedInUser);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .header("Location", "/auth/users/" + loggedInUser.getId())
//                    .body(jwtToken);
            return new ResponseEntity<>(jwtToken,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/users/{id}")
    public User getUserProfile(@PathVariable String emailId) {
        return userService.getUserById(emailId);
    }

    private String generateToken(User user){
        String jwtToken= "";
        jwtToken = Jwts.builder()
                .setSubject(user.getEmailId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,jwtSecret)
                .compact();
        return jwtToken;
    }
}
