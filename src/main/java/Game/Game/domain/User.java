package Game.Game.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private Long id;
    private String nickName;
    private Long level;
    private Long experience;
    private LocalDateTime createdAt;

    /*
    * 사용시점 : ALL
    * 1. levelCheck
    * 2. nickNameCheck
    * */
    public User (Long id, String nickName, Long level, Long experience, LocalDateTime createdAt) {
        this.id = id;
        this.nickName = nickName;
        this.level = levelCheck(level);
        this.experience = experience;
        this.createdAt = createdAt;
        nickNameCheck();
    }

    public static User signUp(final String nickname){
        return new User(null, nickname, null, 0L, LocalDateTime.now());
    }

    public User() {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /*
    * 사용시점 : 생성자
    * 설명 : 닉네임이 10글자 초과시 오류 발생
    * */
    private void nickNameCheck() {
        if(nickName.length() > 10) {
                throw new IllegalArgumentException("닉네임은 10글자를 초과할 수 없습니다.");
        }
    }

    /*
    * 사용시점 : 생성자
    * 1. 파라미터가 null일 경우 1L 반환
    * 2. 파라미터가 레벨이 있을경우 그대로 반환
    * */
    private Long levelCheck(Long level) {
        if(level == null){
            return 1L;
        }

        return level;
    }

    /*
    * 사용하는 클래스 : userService.hunt()
    * 몬스터의 경험치 합을 받아 레벨과 경험치를 증가시키는 함수
    * */
    public void levelUp(Long experience) {
        this.experience = this.experience + experience;
        if(this.experience >= 100) {
            level = level + this.experience/100;
            this.experience = this.experience%100;
        }
    }
}