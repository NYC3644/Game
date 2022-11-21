package Game.Game.Dto;

public class MonsterSaveDto {
    private String monsterName;
    private Long experience;

    public MonsterSaveDto(String monsterName, Long experience) {
        this.monsterName = monsterName;
        this.experience = experience;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }
}
