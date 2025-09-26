package playground.websocketchat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import playground.websocketchat.dto.JoinRoomRequestDTO;
import playground.websocketchat.dto.MessageResponseDTO;
import playground.websocketchat.entity.ChatRoom;
import playground.websocketchat.entity.Message;
import playground.websocketchat.entity.User;
import playground.websocketchat.entity.enums.ChatMessageType;
import playground.websocketchat.repository.ChatRoomMembersRepository;
import playground.websocketchat.repository.ChatRoomRepository;
import playground.websocketchat.repository.UserRepository;
import playground.websocketchat.service.ChatHandlingService;
import playground.websocketchat.service.ChatRoomService;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatHandlingService chatHandlingService;

    @MessageMapping("/chat.join")
    @SendTo("/topic/room/{roomId}")
    public MessageResponseDTO join(JoinRoomRequestDTO joinRequest) {
       return  chatHandlingService.handleJoin(joinRequest);

    }
}
