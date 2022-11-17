package Game.Game.Dto;

public class UserSaveDto {

    private String nickName;

    public UserSaveDto(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
