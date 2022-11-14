package Game.Game.domain;

import java.time.LocalDate;

public class User {
    private Long id;
    private String nickName;
    private Long level;
    private Long experience;
    private LocalDate createdAt;

    public User (Long id, String nickName, Long level, Long experience, LocalDate createdAt) {
        this.id = id;
        this.nickName = nickName;
        this.level = levelCheck(level);
        this.experience = experience;
        this.createdAt = createdAt;
        nickNameCheck();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    private void nickNameCheck() {
        if(nickName.length() >= 10) {
                throw new IllegalArgumentException("닉네임은 10글자 이상일 수 없습니다.");
        }
    }

    private Long levelCheck(Long level) {
        if(level == null){
            return 1L;
        }

        return level;
    }

    public void levelUp(Long experience) {
        this.experience = this.experience + experience;
        if(this.experience >= 100) {
            level = level + this.experience/100;
            this.experience = this.experience%100;
        }
    }
}