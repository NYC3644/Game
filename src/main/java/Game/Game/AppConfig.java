package Game.Game;

import Game.Game.domain.User;
import Game.Game.repository.UserMapper;
import Game.Game.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final UserMapper userMapper;

    public AppConfig(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Bean
    public UserService userService() {
        return new UserService(userMapper);
    }
}
