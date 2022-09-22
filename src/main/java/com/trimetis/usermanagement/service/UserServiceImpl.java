package com.trimetis.usermanagement.service;

import com.google.common.hash.Hashing;
import com.trimetis.usermanagement.dataaccess.UserRepository;
import com.trimetis.usermanagement.dto.UserDTO;
import com.trimetis.usermanagement.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user = encryptUserPassword(user);
        return userRepository.save(user);
    }

    private User encryptUserPassword(User user) {
        if (user != null) {
            String originalPassword = user.getName().trim().concat(user.getPassword());
            String encryptedPassword = Hashing.sha256().hashString(originalPassword, StandardCharsets.UTF_8).toString();
            user.setPassword(encryptedPassword);
        }
        return user;
    }
}
