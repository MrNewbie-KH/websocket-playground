package playground.websocketchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.websocketchat.entity.ChatRoom;


public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {
}
