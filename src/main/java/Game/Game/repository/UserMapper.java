package Game.Game.repository;

import Game.Game.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    void save(User user);

    User findByNickName(String nickName);

    Optional<User> findById(Long id);

    User hunt(Long userId, Long level, Long experience);
}