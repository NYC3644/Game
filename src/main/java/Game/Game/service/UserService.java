package Game.Game.service;

import Game.Game.domain.User;
import Game.Game.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User save(User user) {
        userMapper.save(user);

        return user;
    }
}
