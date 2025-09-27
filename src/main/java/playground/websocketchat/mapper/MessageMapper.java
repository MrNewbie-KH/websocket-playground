package playground.websocketchat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import playground.websocketchat.dto.MessageRequestDTO;
import playground.websocketchat.dto.MessageResponseDTO;
import playground.websocketchat.entity.Message;

@Mapper(componentModel = "spring",uses = {UserMapper.class,ChatRoomMapper.class})
public interface MessageMapper {
    MessageResponseDTO toDTO(Message message);
    Message toEntity(MessageRequestDTO messageRequestDTO);
}

