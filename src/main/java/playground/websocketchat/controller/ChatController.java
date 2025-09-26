package playground.websocketchat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import playground.websocketchat.dto.JoinRoomRequestDTO;
import playground.websocketchat.dto.MessageRequestDTO;
import playground.websocketchat.dto.MessageResponseDTO;
import playground.websocketchat.service.ChatHandlingService;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatHandlingService chatHandlingService;

    @MessageMapping("/chat.join")
    public MessageResponseDTO join(@Payload JoinRoomRequestDTO joinRequest, SimpMessageHeaderAccessor headerAccessor) {
        return chatHandlingService.handleJoin(joinRequest, headerAccessor);

    }

    @MessageMapping("/chat.message")
    public MessageResponseDTO sendMessage(@Payload MessageRequestDTO messageRequestDTO, SimpMessageHeaderAccessor headerAccessor) {
        return chatHandlingService.handleMessage(messageRequestDTO, headerAccessor);

    }
}
