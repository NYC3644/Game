package Game.Game.repository;

import Game.Game.Dto.MonsterInfoDto;
import Game.Game.domain.Monster;
import Game.Game.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MonsterMapper {
    void save(Monster monster);

    Optional<Monster> findByMonsterName(String monsterName);

    Optional<Monster> findById(Long id);
    List<MonsterInfoDto> selectAll(String monsterName);
}
