package playground.websocketchat.mapper;

import org.mapstruct.Mapper;
import playground.websocketchat.dto.UserRequestDTO;
import playground.websocketchat.dto.UserResponseDTO;
import playground.websocketchat.entity.User;

@Mapper (componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toUserResponseDTO(User user);

    User toUserEntity(UserRequestDTO userRequestDTO);
}
