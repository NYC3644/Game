package Game.Game.service;

import Game.Game.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("회원 정보 저장")
    void UserSave() {

        //given
        Long id = 1L;
        String nickName = "nyc";
        Long level = null;
        Long experience = 0L;
        LocalDate createAt = LocalDate.now();

        //when
        User actual = new User(id, nickName, level, experience, createAt);
        userService.save(actual);

        //then
        assertThat(actual.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("닉네임으로 검색")
    void findByNickName() {
        //given
        Long id = 1L;
        String nickName = "nyc";
        Long level = null;
        Long experience = 0L;
        LocalDate createAt = LocalDate.now();
        User user = new User(id, nickName, level, experience, createAt);

        //when
        User actual = userService.save(user);
        User findByNickName = userService.findByNickName(nickName);

        //then
        assertThat(actual.getNickName()).isEqualTo(findByNickName.getNickName());
    }
}