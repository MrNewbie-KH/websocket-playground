package playground.websocketchat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import playground.websocketchat.dto.ChatRoomRequestDTO;
import playground.websocketchat.dto.ChatRoomResponseDTO;
import playground.websocketchat.entity.ChatRoom;
import playground.websocketchat.mapper.ChatRoomMapper;
import playground.websocketchat.repository.ChatRoomRepository;

@Service
@AllArgsConstructor
public class ChatRoomService {
    private ChatRoomMapper chatRoomMapper;
    private final ChatRoomRepository chatRoomRepository;
    public ChatRoomResponseDTO createChatRoom(ChatRoomRequestDTO chatRoomRequestDTO) {
       ChatRoom room =  chatRoomRepository.save(chatRoomMapper.toEntity(chatRoomRequestDTO));
       return chatRoomMapper.toDTO(room);

    }

}
