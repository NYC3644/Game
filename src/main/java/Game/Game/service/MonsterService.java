package Game.Game.service;

import Game.Game.domain.Monster;
import Game.Game.repository.MonsterMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MonsterService {

    private final MonsterMapper monsterMapper;

    @Autowired
    public MonsterService(MonsterMapper monsterMapper) {
        this.monsterMapper = monsterMapper;
    }

    public Monster save(Monster monster){
        monsterMapper.save(monster);

        return monster;
    }

    public Monster findByMonsterName(String monsterName) {
        return monsterMapper.findByMonsterName(monsterName);
    }
}
