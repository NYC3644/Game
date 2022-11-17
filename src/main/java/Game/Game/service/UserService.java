package Game.Game.service;

import Game.Game.Dto.UserSaveDto;
import Game.Game.domain.User;
import Game.Game.repository.MonsterMapper;
import Game.Game.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

public class UserService {

    private final UserMapper userMapper;
    private final MonsterMapper monsterMapper;

    @Autowired
    public UserService(UserMapper userMapper, MonsterMapper monsterMapper) {
        this.userMapper = userMapper;
        this.monsterMapper = monsterMapper;
    }

    public void save(UserSaveDto request) {
        User user = User.signUp(request.getNickName());
        userMapper.save(user);
    }

    public Optional<User> findByNickName(String nickName) {
        return Optional.ofNullable(userMapper.findByNickName(nickName));
    }

    public void hunt(String nickName ,Long monsterId , int num) {
        // 몬스터 경험치 * num = 총 경험치
        userMapper.findByNickName(nickName);
    }
}