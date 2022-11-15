package Game.Game.service;

import Game.Game.domain.User;
import Game.Game.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User save(User user) {
        userMapper.save(user);
        System.out.println("user = " + user);
        return user;
    }
}
