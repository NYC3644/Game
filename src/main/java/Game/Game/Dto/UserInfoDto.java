package Game.Game.Dto;

import Game.Game.domain.User;

import java.time.LocalDateTime;

public class UserInfoDto {

    private Long id;
    private String nickname;
    private Long level;
    private Long experience;
    private LocalDateTime createdAt;

    public UserInfoDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.level = user.getLevel();
        this.experience = user.getExperience();
        this.createdAt = user.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Long getLevel() {
        return level;
    }

    public Long getExperience() {
        return experience;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
