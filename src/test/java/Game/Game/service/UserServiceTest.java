package Game.Game.service;

import Game.Game.Dto.UserSaveDto;
import Game.Game.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("회원 정보 저장")
    void UserSave() {
        //given
        String nickName = "nyc";

        //when
        userService.save(new UserSaveDto(nickName));
        Optional<User> actual = userService.findByNickName(nickName);

        //then
        assertThat(actual.isPresent()).isTrue();
    }

    @Test
    @DisplayName("닉네임으로 검색")
    void findByNickName() {
        //given
        String nickName = "nyc";

        //when
        userService.save(new UserSaveDto(nickName));
        User actual = userService.findByNickName(nickName).get();

        //then
        assertThat(actual.getNickName()).isEqualTo(nickName);
    }
}