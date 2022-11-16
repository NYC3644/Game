package Game.Game.service;

import Game.Game.domain.Monster;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MonsterServiceTest {

    @Autowired
    private MonsterService monsterService;

    @Test
    @DisplayName("몬스터 정보 생성")
    void MonsterSave() {
        //given
        Monster actual = new Monster(1L, "Orc", 20L);

        //when
        monsterService.save(actual);

        //then
        assertThat(actual.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("몬스터 이름으로 검색")
    void findByMonsterName() {
        //given
        Long id = 1L;
        String monsterName = "Orc";
        Long experience = 20L;
        Monster monster = new Monster(id, monsterName, experience);

        //when
        Monster actual = monsterService.save(monster);
        Monster findByMonsterName = monsterService.findByMonsterName(monsterName);

        //then
        assertThat(actual.getMonsterName()).isEqualTo(findByMonsterName.getMonsterName());
    }
}