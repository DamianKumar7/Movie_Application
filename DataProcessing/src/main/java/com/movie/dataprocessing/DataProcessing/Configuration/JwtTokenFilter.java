package com.movie.dataprocessing.DataProcessing.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class JwtTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if(!authHeader.isBlank() && authHeader.startsWith("Bearer ")){
            String jwtToken = authHeader.split(" ")[1].trim();

            try{
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(secret)
                        .build()
                        .parseClaimsJws(jwtToken)
                        .getBody();
                String emailId = request.getHeader("email-id");
                String subject = claims.getSubject();

                if(emailId.equals(subject)){
                    filterChain.doFilter(request,response);
                }
                else {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                }

            }
            catch(Exception e){
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            }
        }
        else{
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
    }
}
