package playground.websocketchat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponseDTO {
    private final String message;
    private final ChatRoomResponseDTO room;
    private final UserResponseDTO sender;
    private final Long id;
}
