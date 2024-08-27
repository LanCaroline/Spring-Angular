import org.buildingthef.dto.UserDTO;
import org.buildingthef.mapper.UserMapper;
import org.buildingthef.model.UserModel;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Main {

    private final static UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {
        var model = new UserModel();
        model.setCode(1);
        model.setUserName("James");
        model.setBrithday(LocalDate.now().minusYears(20));
        System.out.println(mapper.toDTO(model));


        var dto = new UserDTO();

        dto.setId(2);
        dto.setName("Mary");
        dto.setBirthday(LocalDate.now().minusYears(30));
        System.out.println(mapper.toModel(dto));


    }
}
