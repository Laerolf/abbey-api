package com.abbey.api.services;

import com.abbey.api.models.authentication.User;
import com.abbey.api.repositories.authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        try {
            User user = userRepository.findByUsername(username);
            return UserDetailsImplementation.build(user);
        }
        catch(UsernameNotFoundException exception){
            throw new UsernameNotFoundException("User not found with username '"+username+"'");
        }
    }

}
