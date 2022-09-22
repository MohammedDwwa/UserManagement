package com.trimetis.usermanagement.controller;

import com.trimetis.usermanagement.dto.UserDTO;
import com.trimetis.usermanagement.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerIntegrationTest {
    @Autowired
    private UserController userController;

    @Test
    public final void saveUser() {
        String name = "Name1";
        String password = "Password1";
        String hashedPassword = "b9efd0093bc77cd96e6f86db09321ffe5cb4ffa7634df89df586379fe6276cc8";
        User user = getInitiatedUser(name, password);
        UserDTO dto = userController.save(user);
        assertNotNull(dto);
        assertNotNull(dto.getName());
        assertNotNull(dto.getHashedPassword());
        assertEquals(dto.getHashedPassword(), hashedPassword);
    }

    private User getInitiatedUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }
}
