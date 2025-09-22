package playground.websocketchat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import playground.websocketchat.entity.Message;

@Controller
public class ChatController {
    @MessageMapping("/chat.addUserToChatRoom")
    @SendTo("/topic/room1")
    public Message addUserToChatRoom(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
//    first add user to chatting area thin you gonna be able to send messages
        return   message;
    }
}
