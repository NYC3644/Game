package Game.Game.Dto;

public class HuntDto {

    private Long monsterId;

    private int number;

    public HuntDto(Long monsterId, int number) {
        this.monsterId = monsterId;
        this.number = number;
    }

    public Long getMonsterId() {
        return monsterId;
    }

    public int getNumber() {
        return number;
    }

    public void setMonsterId(Long monsterId) {
        this.monsterId = monsterId;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
