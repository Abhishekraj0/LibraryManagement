package com.ivoyant.Service;

import com.ivoyant.dto.UserRegistrationDto;
import com.ivoyant.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
}
