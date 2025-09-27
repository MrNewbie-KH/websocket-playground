package playground.websocketchat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import playground.websocketchat.entity.enums.UserMembershipType;
import playground.websocketchat.entity.enums.UserRole;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "chatroom_members",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "room_id"})
        }
)@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoomMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private LocalDateTime joinedAt;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User member;
    @ManyToOne
    @JoinColumn(name = "room_id",nullable = false)
    private ChatRoom room;
    @Column(nullable = false)
    private LocalDateTime lastActiveAt;
    @Enumerated(EnumType.STRING)
    private UserMembershipType  userMembershipType;

}
