package playground.websocketchat.service;

import org.springframework.stereotype.Service;
import playground.websocketchat.dto.MessageResponseDTO;
import playground.websocketchat.entity.ChatRoom;
import playground.websocketchat.entity.Message;
import playground.websocketchat.entity.User;
import playground.websocketchat.entity.enums.ChatMessageType;

@Service
public class ChatHandlingService {
    public MessageResponseDTO handleJoin(){
        return null ;
        ChatRoom room = chatRoomRepository.findById(joinRequest.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        User user = userRepository.findUserByEmail(joinRequest.getEmail());
        // Save member if not already in
        if (!chatRoomMembersRepository.existsByRoomAndUser(room, user)) {
            chatRoomMembersRepository.save(ChatRoomMembers.builder()
                    .room(room)
                    .email(request.getSender())
                    .build());
        }

        // Return a system message (broadcasted to room)
        return Message.builder()
                .type(ChatMessageType.JOIN)
                .sender(request.getSender())
                .content(request.getSender() + " joined the room")
                .room(room.getId())
                .build();
    }
    }
}
