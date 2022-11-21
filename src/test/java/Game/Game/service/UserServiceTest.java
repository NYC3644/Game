package Game.Game.service;

import Game.Game.Dto.UserSaveDto;
import Game.Game.domain.Monster;
import Game.Game.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("회원 정보 저장")
    void UserSave() {
        //given
        String nickName = "nyc1";

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
        String nickName = "nyc1";

        //when
        userService.save(new UserSaveDto(nickName));
        User actual = userService.findByNickName(nickName).get();

        //then
        assertThat(actual.getNickName()).isEqualTo(nickName);
    }

    @Test
    @DisplayName("ID로 검색")
    void findById() {
        //given
        String nickName = "Orc";
        UserSaveDto user = new UserSaveDto(nickName);

        //when
        Long id = userService.save(user);
        User bb = userService.findById(id);

        //then
        assertThat(bb.getId()).isEqualTo(id);
    }
}