package com.Contact_Manager.contact_manager.ServicesImpl;


import com.Contact_Manager.contact_manager.Repositories.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SecurityCustomerUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public SecurityCustomerUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User not found with this email Id"));
    }
}
