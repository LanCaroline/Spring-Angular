package org.buildingthef.mapper;

import javax.annotation.processing.Generated;
import org.buildingthef.dto.UserDTO;
import org.buildingthef.model.UserModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-15T13:44:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel toModel(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setCode( dto.getId() );
        userModel.setUserName( dto.getName() );

        return userModel;
    }

    @Override
    public UserDTO toDTO(UserModel model) {
        if ( model == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( model.getCode() );
        userDTO.setName( model.getUserName() );

        return userDTO;
    }
}
