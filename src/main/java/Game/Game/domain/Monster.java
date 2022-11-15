package Game.Game.domain;

public class Monster {

    private Long id;
    private String monsterName;
    private Long experience;

    public Monster(Long id, String monsterName, Long experience) {
        this.id = id;
        this.monsterName = monsterName;
        this.experience = experience;

        monsterNameCheck();
        monsterExperience();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private void monsterNameCheck() {
        if(monsterName.length() > 10) {
            throw new IllegalArgumentException("닉네임은 10글자를 초과할 수 없습니다");
        }
    }

    private void monsterExperience() {
        if(experience > 100) {
            throw new IllegalArgumentException("몬스터 경험치는 100을 초과할 수 없습니다");
        }
    }
}