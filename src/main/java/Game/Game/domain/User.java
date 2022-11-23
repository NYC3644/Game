package Game.Game.domain;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String nickname;
    private Long level;
    private Long experience;
    private LocalDateTime createdAt;

    /*
    * 사용시점 : ALL
    * 1. levelCheck
    * 2. nicknameCheck
    * */
    public User (Long id, String nickname, Long level, Long experience, LocalDateTime createdAt) {
        this.id = id;
        this.nickname = nickname;
        this.level = levelCheck(level);
        this.experience = experience;
        this.createdAt = createdAt;
        nickNameCheck();
    }

    /*
    * 사용시점: save(회원가입)
    * 설명: 유저 회원가입시 닉네임만 입력하면 나머지 값은 자동으로 입력
    * */
    public static User signUp(final String nickname){
        return new User(null, nickname, null, 0L, LocalDateTime.now());
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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


    /*
    * 사용시점 : 생성자
    * 설명 : 닉네임이 10글자 초과시 오류 발생
    * */
    private void nickNameCheck() {
        if(nickname.length() > 10) {
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