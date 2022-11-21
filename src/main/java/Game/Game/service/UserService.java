package Game.Game.service;

import Game.Game.Dto.HuntDto;
import Game.Game.Dto.UserSaveDto;
import Game.Game.domain.Monster;
import Game.Game.domain.User;
import Game.Game.repository.MonsterMapper;
import Game.Game.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class UserService {

    private final UserMapper userMapper;
    private final MonsterMapper monsterMapper;

    @Autowired
    public UserService(UserMapper userMapper, MonsterMapper monsterMapper) {
        this.userMapper = userMapper;
        this.monsterMapper = monsterMapper;
    }


    public Long save(UserSaveDto request) {
        validateExistNickname(request.getNickName());

        User user = User.signUp(request.getNickName());
        userMapper.save(user);
        return user.getId();
    }

    private void validateExistNickname(String nickname) {
        if(findByNickName(nickname).isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    public Optional<User> findByNickName(String nickName) {
        return Optional.ofNullable(userMapper.findByNickName(nickName));
    }

    public User findById(Long id) {
        return userMapper.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }


    public void hunt(Long userId ,Long monsterId , int num) {
        // 아이디를 통해 유저 정보 및 몬스터 정보 조회
        // monster는 null이 발생할 가능성이 있음.
        User user = findById(userId);
        //TODO: 이후 Optional 에러체크 로직 구현
        Monster monster = monsterMapper.findById(monsterId).get();

        // 몬스터 경험치 * num = 총 경험치
        long ex = monster.getExperience() * num;

        //user 경험치에 몬스터 경험치를 더함 = 유저 경험치로
        user.levelUp(ex);

        //user 정보를 업데이트
        userMapper.hunt(userId, user.getLevel(), user.getExperience());
    }

    public void hunt(Long userId , List<HuntDto> request) {
        // 아이디를 통해 유저 정보 및 몬스터 정보 조회
        User user = findById(userId);

        //user 경험치에 몬스터 경험치를 더함 = 유저 경험치로
        user.levelUp(totalExperience(request));

        //user 정보를 업데이트
        userMapper.hunt(userId, user.getLevel(), user.getExperience());
    }

    private Long totalExperience(List<HuntDto> request) {
        Long totalEx = 0L;

        for (HuntDto huntDto : request) {
            Monster monster = monsterMapper.findById(huntDto.getMonsterId()).get();
            totalEx += monster.getExperience() * huntDto.getNumber();
        }
        return totalEx;
    }
}