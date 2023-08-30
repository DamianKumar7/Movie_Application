package com.damian.auth.Util;
import com.damian.auth.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtGeneratorUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user){
        String jwtToken= "";
        jwtToken = Jwts.builder()
                .setSubject(user.getEmailId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
        return jwtToken;
    }


}
