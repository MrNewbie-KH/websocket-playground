package playground.websocketchat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import playground.websocketchat.entity.enums.UserRole;

import java.time.LocalDateTime;

@Entity
@Table(name = "chatroom_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoomMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UserRole userRole;
    private LocalDateTime joinedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User member;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private ChatRoom room;

}
