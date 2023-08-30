package com.damian.auth.service;
import com.damian.auth.DTO.LoginRequest;
import com.damian.auth.DTO.RegistrationRequest;
import com.damian.auth.model.User;
import com.damian.auth.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;




    public boolean registerUser(@org.jetbrains.annotations.NotNull RegistrationRequest registrationRequest) {
        User newUser = new User();
        if (userRepository.findByEmailId(registrationRequest.getEmailId()) != null) {
//            logger.info(String.format("User already exists with the email id: %s",registrationRequest.getEmailId()));
            return false;
        }
        newUser.setEmailId(registrationRequest.getEmailId());
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setPassword((registrationRequest.getPassword()));
        userRepository.save(newUser);
//        logger.info(String.format("User registered with email id: %s",registrationRequest.getEmailId()));
        return true;
    }

    public User loginUser(LoginRequest loginRequest){
        User user = userRepository.findByEmailId(loginRequest.getEmailId());
        if(user != null && loginRequest.getPassword().equalsIgnoreCase( user.getPassword())){
            return user;

        }
        return null;
    }

    public User getUserById(String emailId) {
        User user = userRepository.findByEmailId(emailId);
        return user;
    }
}
