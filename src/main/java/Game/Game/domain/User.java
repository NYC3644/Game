package Game.Game.domain;

import java.time.LocalDate;

public class User {
    private Long id;
    private String nickName;
    private Long level;
    private Long experience;
    private LocalDate createdAt;

    public User(Long id, String nickName, Long level, Long experience, LocalDate createdAt) {
        this.id = id;
        this.nickName = nickName;
        this.level = level;
        this.experience = experience;
        this.createdAt = createdAt;
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
}
