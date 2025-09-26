package playground.websocketchat.entity;

import lombok.Data;
import playground.websocketchat.entity.enums.ChatMessageType;

@Data
public class MessageTest {
    private String content;
    private ChatMessageType type;
}