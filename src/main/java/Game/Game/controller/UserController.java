package Game.Game.controller;

import Game.Game.Dto.UserInfoDto;
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

    /*
    * 회원가입기능(유저 닉네임만 입력시 나머지 값 자동 등록)
    * */
    @PostMapping("/api/v1/members/signup")
    public void signUp(@RequestBody UserSaveDto userSaveDto){
        userService.save(userSaveDto);
    }

    /*
    * 가입된 유저의 정보 가져오기(1명)
    * */
    @GetMapping("/api/v1/members/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/api/v1/members/select/{nickname}")
    public UserInfoDto selectUser(@PathVariable String nickname) {
        User user = userService.findByNickName(nickname).orElseThrow(() -> new IllegalArgumentException());

        return new UserInfoDto(user);
    }
}
