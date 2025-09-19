package playground.websocketchat.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import playground.websocketchat.entity.enums.UserRole;

import java.time.LocalDateTime;

public class ChatRoomMembers {
    private Long id;
    private UserRole userRole;
    private LocalDateTime joinedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private ChatRoom chatRoom;

}
