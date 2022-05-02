package anderson.dev.produceravro.controllers;

import anderson.dev.produceravro.dtos.UserDTO;
import anderson.dev.produceravro.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDTO));
    }
}
