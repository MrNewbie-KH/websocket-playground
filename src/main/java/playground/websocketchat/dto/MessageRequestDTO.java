package playground.websocketchat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import playground.websocketchat.entity.enums.ChatMessageType;

@Data
@AllArgsConstructor
public class MessageRequestDTO {
    private String message;
    private ChatMessageType chatMessageType;

}
