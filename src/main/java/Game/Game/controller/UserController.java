package Game.Game.controller;

import Game.Game.Dto.*;
import Game.Game.domain.User;
import Game.Game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    /*
    * 이름으로 유저 정보 검색
    * 반환타입 Dto
    * */
    @GetMapping("/api/v1/members/select/{nickname}")
    public UserInfoDto selectUser(@PathVariable String nickname) {
        User user = userService.findByNickName(nickname).orElseThrow(() -> new IllegalArgumentException());

        return new UserInfoDto(user);
    }

    @PostMapping("/api/v1/members/{id}/hunt")
    public void hunt(@PathVariable Long id, @RequestBody List<HuntDto> huntDto){
        userService.hunt(id, huntDto);
    }

    @GetMapping("/api/v2/members/selectAll/{name}")
    public List<UserInfoDto> selectAll(@PathVariable String name) {
        List<UserInfoDto> userInfo = userService.selectAll(name);
        return userInfo;
    }
}
