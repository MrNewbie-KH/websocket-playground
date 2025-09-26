package playground.websocketchat.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playground.websocketchat.dto.UserRequestDTO;
import playground.websocketchat.dto.UserResponseDTO;
import playground.websocketchat.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @PostMapping
//    create dumb user before authentication
    public UserResponseDTO createDumbUser(@RequestBody UserRequestDTO userRequestDTO){
       return userService.createUser(userRequestDTO);
    };
}
