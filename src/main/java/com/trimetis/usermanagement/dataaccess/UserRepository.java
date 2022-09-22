package com.trimetis.usermanagement.dataaccess;

import com.trimetis.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
