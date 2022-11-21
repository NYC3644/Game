package Game.Game.Dto;

import Game.Game.domain.Monster;
import Game.Game.service.MonsterService;

public class MonsterInfoDto {
    private Long id;
    private String monsterName;
    private Long experience;

    public MonsterInfoDto(Monster monster) {
        this.id = monster.getId();
        this.monsterName = monster.getMonsterName();
        this.experience = monster.getExperience();
    }

    public Long getId() {
        return id;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public Long getExperience() {
        return experience;
    }
}
