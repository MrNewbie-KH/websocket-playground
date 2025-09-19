package playground.websocketchat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import playground.websocketchat.entity.enums.UserStatus;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    UserStatus status;
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<Message> messages;
    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private List<ChatRoomMembers> chatRoomMembers;
}
