package playground.websocketchat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import playground.websocketchat.entity.enums.ChatMessageType;

import java.util.List;

@Entity
@Table(name = "chat_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @OneToMany(mappedBy = "room")
    private List<Message> messages;
    @OneToMany(mappedBy = "room")
    private List<ChatRoomMembers> chatRoomMembers;
}
