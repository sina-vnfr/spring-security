package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.dto.user;
import com.example.springsecuritydemo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class myAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private userRepository userRepository2;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();


        Boolean gg = userRepository2.existsByUsername(name);
        user user=userRepository2.getAllByUsername(name);
            if (gg){
                if (user.getPassword().equals(password))
                {
                    return new UsernamePasswordAuthenticationToken(
                           name, password, new ArrayList<>());
                }
                else {
                    throw new BadCredentialsException("invalid user or pass");
                }
            }
            else {
                throw new BadCredentialsException("invalid user or pass");
            }

    }

    @Override
    public boolean supports(Class<?> authentication) {
      return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
