package Game.Game.service;

import Game.Game.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    @Autowired
    private final UserService userService;

    UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    @DisplayName("회원 정보 저장")
    void save() {

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
}