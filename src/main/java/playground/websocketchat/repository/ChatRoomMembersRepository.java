package playground.websocketchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.websocketchat.entity.ChatRoom;
import playground.websocketchat.entity.ChatRoomMembers;
import playground.websocketchat.entity.User;

public interface ChatRoomMembersRepository extends JpaRepository<ChatRoomMembers, Long> {
    boolean existsByRoomAndMember(ChatRoom room, User user);
}
