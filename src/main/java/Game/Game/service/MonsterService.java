package Game.Game.service;

import Game.Game.Dto.MonsterInfoDto;
import Game.Game.Dto.MonsterSaveDto;
import Game.Game.domain.Monster;
import Game.Game.repository.MonsterMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

public class MonsterService {

    private final MonsterMapper monsterMapper;

    @Autowired
    public MonsterService(MonsterMapper monsterMapper) {
        this.monsterMapper = monsterMapper;
    }

    /*
    * 몬스터 정보 저장
    * 몬스터 이름 중복 허용 안함
    */
    public Long save(MonsterSaveDto request){
        validateExistMonsterName(request.getMonsterName());

        Monster monster = Monster.add(request.getMonsterName(), request.getExperience());
        monsterMapper.save(monster);

        return monster.getId();
    }

    //isPresent: 값이 있으면 true 반환
    private void validateExistMonsterName(String monsterName) {
        if(monsterMapper.findByMonsterName(monsterName).isPresent())
        {
            throw new IllegalArgumentException();
        }
    }

    /*
    * 몬스터 이름으로 검색
    * orElseThrow: null 일경우 오류 반환
    * */
    public Monster findByMonsterName(String monsterName) {
        return monsterMapper.findByMonsterName(monsterName)
                .orElseThrow(IllegalArgumentException::new);
    }

    public MonsterInfoDto findByMonsterId(Long id) {
        Optional<Monster> monsterId = monsterMapper.findById(id);
        Monster monster = monsterId.orElseThrow(() -> new IllegalArgumentException());

        return new MonsterInfoDto(monster);
    }
}
