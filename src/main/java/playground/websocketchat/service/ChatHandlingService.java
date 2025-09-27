package playground.websocketchat.service;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import playground.websocketchat.dto.*;
import playground.websocketchat.entity.ChatRoom;
import playground.websocketchat.entity.Message;
import playground.websocketchat.entity.User;
import playground.websocketchat.entity.enums.ChatMessageType;
import playground.websocketchat.entity.enums.UserRole;
import playground.websocketchat.mapper.ChatRoomMembersMapper;
import playground.websocketchat.mapper.MessageMapper;
import playground.websocketchat.repository.ChatRoomMembersRepository;
import playground.websocketchat.repository.ChatRoomRepository;
import playground.websocketchat.repository.MessageRepository;
import playground.websocketchat.repository.UserRepository;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ChatHandlingService {
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;
    private final ChatRoomMembersRepository chatRoomMembersRepository;
    private final ChatRoomMembersMapper chatRoomMembersMapper;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    public MessageResponseDTO handleJoin(JoinRoomRequestDTO joinRoomRequestDTO, SimpMessageHeaderAccessor  headerAccessor ) {

        ChatRoom room = chatRoomRepository.findById(joinRoomRequestDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        User user = userRepository.findUserByEmail(joinRoomRequestDTO.getEmail())
                        .orElseThrow(() -> new RuntimeException("User not found"));


        headerAccessor.getSessionAttributes().put("user", user);
        headerAccessor.getSessionAttributes().put("room", room);
        System.out.println(user.getName());

        // Save member if not already in
        if(!chatRoomMembersRepository.existsByRoomAndMember(room, user)){
            chatRoomMembersRepository.save(chatRoomMembersMapper.toEntity(new ChatRoomMembersRequestDTO(room,user,UserRole.MEMBER)));
        }

        return handleMessage(new MessageRequestDTO("Hello, New join to the channel"), headerAccessor);


    }

    public MessageResponseDTO handleMessage(MessageRequestDTO messageRequestDTO, SimpMessageHeaderAccessor  headerAccessor) {
        User user  = (User) headerAccessor.getSessionAttributes().get("user");
        ChatRoom room  = (ChatRoom) headerAccessor.getSessionAttributes().get("room");
//       dirty now and i'lll clean it next
        Message message = new Message();
        message.setMessage(messageRequestDTO.getMessage());
        message.setRoom(room);
        message.setSender(user);
        message.setType(ChatMessageType.MESSAGE);
        message.setCreatedAt(LocalDateTime.now());
        messageRepository.save(message);
//        -------------------------------------------
        MessageResponseDTO messageResponseDTO =messageMapper.toDTO(message);
        messagingTemplate.convertAndSend("/topic/room/" + room.getId(), messageResponseDTO);
        return messageResponseDTO;

    }
}
