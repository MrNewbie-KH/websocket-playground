package playground.websocketchat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import playground.websocketchat.entity.ChatRoom;
import playground.websocketchat.entity.User;
import playground.websocketchat.entity.enums.UserMembershipType;
import playground.websocketchat.entity.enums.UserRole;

@Data
@AllArgsConstructor
public class ChatRoomMembersRequestDTO {
    private final ChatRoom room;
    private final User member;
    private final UserRole userRole;
    private final UserMembershipType userMembershipType;
}
