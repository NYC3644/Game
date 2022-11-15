package Game.Game.repository;

import Game.Game.domain.Monster;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MonsterMapper {
    void save(Monster monster);
}
