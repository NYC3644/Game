package Game.Game.repository;

import Game.Game.domain.Monster;
import Game.Game.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MonsterMapper {
    void save(Monster monster);

    Optional<Monster> findByMonsterName(String monsterName);

    Optional<Monster> findById(Long id);
}
