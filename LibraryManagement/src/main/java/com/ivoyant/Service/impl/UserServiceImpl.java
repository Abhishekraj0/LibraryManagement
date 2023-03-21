package com.ivoyant.Service.impl;

import com.ivoyant.Repo.UserRepo;
import com.ivoyant.Service.UserService;
import com.ivoyant.dto.UserRegistrationDto;
import com.ivoyant.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private User user;
    private  UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }
@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFullName(),
                userRegistrationDto.getUsername(),
                passwordEncoder.encode(userRegistrationDto.getPassword()));

        return userRepo.save(user);}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByusername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or Password");
        }
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return user.getPassword() ;
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }


}

