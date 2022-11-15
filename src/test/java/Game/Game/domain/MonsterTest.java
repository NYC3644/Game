package Game.Game.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    @Test
    @DisplayName("몬스터를 정상적으로 생성")
    void monster() {
        //given&when&then
        assertDoesNotThrow(() -> new Monster(1L, "asd", 50L));
    }

    @Test
    @DisplayName("몬스터 이름은 10글자를 초과할 수 없다")
    void monsterNameCheck() {
        //given&when&then
        assertThatThrownBy(() -> new Monster(1L, "asdfasdfasdf", 20L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("닉네임은 10글자를 초과할 수 없습니다");
    }

}