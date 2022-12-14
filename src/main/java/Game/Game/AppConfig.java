package Game.Game;

import Game.Game.domain.User;
import Game.Game.repository.MonsterMapper;
import Game.Game.repository.UserMapper;
import Game.Game.service.MonsterService;
import Game.Game.service.UserService;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(UserMapper userMapper, MonsterMapper monsterMapper) {
        return new UserService(userMapper, monsterMapper);
    }

    @Bean
    public MonsterService monsterService(MonsterMapper monsterMapper) {
        return new MonsterService(monsterMapper);
    }
}
