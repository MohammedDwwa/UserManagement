package com.trimetis.usermanagement.controller;

import com.trimetis.usermanagement.dto.UserDTO;
import com.trimetis.usermanagement.model.User;
import com.trimetis.usermanagement.mapper.UserMapper;
import com.trimetis.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.trimetis.usermanagement.util.ApiMapping.ADD_User;
import static com.trimetis.usermanagement.util.ApiMapping.BASE_URL;

@RestController
@RequestMapping(path = BASE_URL)
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping(ADD_User)
    public UserDTO save(@Validated @RequestBody User user) {
        return userMapper.mapUserModelToDTO(userService.saveUser(user));
    }

}
