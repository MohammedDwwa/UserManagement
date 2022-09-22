package com.trimetis.usermanagement.mapper;

import com.trimetis.usermanagement.dto.UserDTO;
import com.trimetis.usermanagement.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "password",target = "hashedPassword")
    UserDTO mapUserModelToDTO(User user);
}
