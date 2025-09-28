package playground.websocketchat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import playground.websocketchat.entity.enums.ChatRoomType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomRequestDTO {
    String title;
    ChatRoomType type;
}
