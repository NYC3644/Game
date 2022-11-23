package Game.Game.controller;

import Game.Game.Dto.MonsterInfoDto;
import Game.Game.Dto.MonsterSaveDto;
import Game.Game.domain.Monster;
import Game.Game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonsterController {

    private final MonsterService monsterService;

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    /*
    * 몬스터 정보 저장
    * */
    @PostMapping("/api/v1/addMonster")
    public void addMonster(@RequestBody MonsterSaveDto monsterSaveDto){
        monsterService.save(monsterSaveDto);
    }

    /*
    * 몬스터 이름으로 정보 조회(1개)
    */
    @GetMapping("/api/v1/addMonster/{monsterName}")
    public Monster findMonster(@PathVariable String monsterName) {
        return monsterService.findByMonsterName(monsterName);
    }

    /*
    * 몬스터 이름으로 정보 조회(1개)
    * 반환 타입 Dto
    * @RequestParam(required는 default가 true, value는 url에 표시됨) -> url+?+=+{monsterName}
    * */
    @GetMapping("/api/v1/monsterInfo")
    public MonsterInfoDto monsterInfo(@RequestParam(value = "name")String monsterName) {
        Monster monster = monsterService.findByMonsterName(monsterName);

        return new MonsterInfoDto(monster);
    }

    @GetMapping("/api/v2/addMonster/{monsterName}")
    public List<MonsterInfoDto> selectAll(@PathVariable String monsterName) {
        return monsterService.selectAll(monsterName);
    }
}
