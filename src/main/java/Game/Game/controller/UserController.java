package Game.Game.controller;

import Game.Game.Dto.UserSaveDto;
import Game.Game.domain.User;
import Game.Game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/members/signup")
    public void signUp(@RequestBody UserSaveDto userSaveDto){
        userService.save(userSaveDto);
    }

    @GetMapping("/api/v1/members/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }
}
