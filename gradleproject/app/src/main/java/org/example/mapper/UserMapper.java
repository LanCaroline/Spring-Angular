package org.example.mapper;

import org.example.dto.UserDTO;
import org.example.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "code", source = "id")
    @Mapping(target = "username", source = "name")
    UserModel tomodel (final UserDTO dto);

    @Mapping(target = "id", source ="code")
    @Mapping(target = "name", source ="username")
    UserDTO todto (final UserModel model);


}
