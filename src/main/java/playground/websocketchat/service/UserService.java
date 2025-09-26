package playground.websocketchat.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import playground.websocketchat.dto.UserRequestDTO;
import playground.websocketchat.dto.UserResponseDTO;
import playground.websocketchat.entity.User;
import playground.websocketchat.mapper.UserMapper;
import playground.websocketchat.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
     User user =    userRepository.save(userMapper.toUserEntity(userRequestDTO));
     return userMapper.toUserResponseDTO(user);
    }
}
