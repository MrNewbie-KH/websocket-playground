package playground.websocketchat.mapper;

import org.mapstruct.Mapper;
import playground.websocketchat.dto.ChatRoomMembersRequestDTO;
import playground.websocketchat.entity.ChatRoomMembers;

@Mapper (componentModel = "spring")
public interface ChatRoomMembersMapper {
    ChatRoomMembers toEntity(ChatRoomMembersRequestDTO chatRoomMembersRequestDTO);
}
