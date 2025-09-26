package playground.websocketchat.service;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import playground.websocketchat.dto.ChatRoomMembersRequestDTO;
import playground.websocketchat.dto.ChatRoomRequestDTO;
import playground.websocketchat.dto.JoinRoomRequestDTO;
import playground.websocketchat.dto.MessageResponseDTO;
import playground.websocketchat.entity.ChatRoom;
import playground.websocketchat.entity.ChatRoomMembers;
import playground.websocketchat.entity.Message;
import playground.websocketchat.entity.User;
import playground.websocketchat.entity.enums.ChatMessageType;
import playground.websocketchat.entity.enums.UserRole;
import playground.websocketchat.mapper.ChatRoomMembersMapper;
import playground.websocketchat.repository.ChatRoomMembersRepository;
import playground.websocketchat.repository.ChatRoomRepository;
import playground.websocketchat.repository.UserRepository;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ChatHandlingService {
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;
    private final ChatRoomMembersRepository chatRoomMembersRepository;
    private final ChatRoomMembersMapper chatRoomMembersMapper;
    public MessageResponseDTO handleJoin(JoinRoomRequestDTO joinRoomRequestDTO){

        ChatRoom room = chatRoomRepository.findById(joinRoomRequestDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        User user = userRepository.findUserByEmail(joinRoomRequestDTO.getEmail());
        // Save member if not already in
        if(!chatRoomMembersRepository.existsByRoomAndUser(room, user)){
            chatRoomMembersRepository.save(chatRoomMembersMapper.toEntity(new ChatRoomMembersRequestDTO(room,user,UserRole.MEMBER)));
        }

        // Return a system message (broadcasted to room)
        return null;
    }
}
