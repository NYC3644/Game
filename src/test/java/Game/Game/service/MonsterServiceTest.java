package Game.Game.service;

import Game.Game.Dto.MonsterInfoDto;
import Game.Game.Dto.MonsterSaveDto;
import Game.Game.domain.Monster;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class MonsterServiceTest {

    @Autowired
    private MonsterService monsterService;

    @Test
    @DisplayName("몬스터 정보 생성")
    void MonsterSave() {
        //given
        MonsterSaveDto orc = new MonsterSaveDto("Orc", 20L);

        //when
        Long actual = monsterService.save(orc);
        MonsterInfoDto monsterInfoDto = monsterService.findByMonsterId(actual);

        //then
        assertThat(actual).isEqualTo(monsterInfoDto.getId());
    }

    @Test
    @DisplayName("몬스터 이름으로 검색")
    void findByMonsterName() {
        //given
        String monsterName = "Orc";
        Long experience = 20L;
        MonsterSaveDto monster = new MonsterSaveDto(monsterName, experience);

        //when
        Long actual = monsterService.save(monster);
        Monster findByMonsterName = monsterService.findByMonsterName(monsterName);

        //then
        assertThat(actual).isEqualTo(findByMonsterName.getId());
    }
}