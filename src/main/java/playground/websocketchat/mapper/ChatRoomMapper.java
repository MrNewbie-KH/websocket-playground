package playground.websocketchat.mapper;

import org.mapstruct.Mapper;
import playground.websocketchat.dto.ChatRoomRequestDTO;
import playground.websocketchat.dto.ChatRoomResponseDTO;
import playground.websocketchat.entity.ChatRoom;

@Mapper (componentModel = "spring")
public interface ChatRoomMapper {
    ChatRoomResponseDTO toDTO(ChatRoom chatRoom);
    ChatRoom toEntity(ChatRoomRequestDTO chatRoomRequestDTO);
}
