package Game.Game.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("맴버를 정상적으로 생성한다")
    void create(){
        //given & when & then
        assertDoesNotThrow(() -> new User(1L, "asd", null, 0L, LocalDate.now()));
    }

    @Test
    @DisplayName("닉네임이 10글자 이상이면 오류를 던진다")
    void create_nicknameCheck(){
        //given
        Long id = 1L;
        String nickname = "asdadwadadw";
        Long level = null;
        Long experience = 0L;
        LocalDate createAt = LocalDate.now();

        //when & then
        assertThatThrownBy(() -> new User(id, nickname, level, experience, createAt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("닉네임은 10글자 이상일 수 없습니다.");
    }

    @Test
    @DisplayName("캐릭터 생성시 레벨은 1랩부터 시작한다")
    void create_level1(){
        //given
        Long id = 1L;
        String nickname = "asdadwadw";
        Long level = null;
        Long experience = 0L;
        LocalDate createAt = LocalDate.now();

        //when
        User actual = new User(id, nickname, level, experience, createAt);

        //then
        assertThat(actual.getLevel()).isEqualTo(1L);
    }

    @Test
    @DisplayName("캐릭터 사냥시 레벨 또는 경험치가 증가한다")
    void levelUp() {
        //given
        Long id = 1L;
        String nickname = "asdadwadw";
        Long level = 2L;
        Long experience = 50L;
        LocalDate createAt = LocalDate.now();

        //when
        User actual = new User(id, nickname, level, experience, createAt);
        actual.levelUp(420L);

        //then
        assertThat(actual.getLevel()).isEqualTo(6L);
        assertThat(actual.getExperience()).isEqualTo(70L);
    }
}