package playground.websocketchat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import playground.websocketchat.dto.MessageRequestDTO;
import playground.websocketchat.dto.MessageResponseDTO;
import playground.websocketchat.entity.Message;

@Mapper(componentModel = "spring",uses = {UserMapper.class,ChatRoomMapper.class})
public interface MessageMapper {
    @Mapping(target = "message",source = "content")
    MessageResponseDTO toDTO(Message message);
    @Mapping(target = "content",source ="message" )
    Message toEntity(MessageRequestDTO messageRequestDTO);
}

