package playground.websocketchat.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playground.websocketchat.dto.ChatRoomRequestDTO;
import playground.websocketchat.dto.ChatRoomResponseDTO;
import playground.websocketchat.service.ChatRoomService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/chat-rooms")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;
    @PostMapping
    public ChatRoomResponseDTO createChatRoom(@RequestBody ChatRoomRequestDTO chatRoomRequestDTO) {
        return chatRoomService.createChatRoom(chatRoomRequestDTO);
    }
}
