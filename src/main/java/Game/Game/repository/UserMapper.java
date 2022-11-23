package Game.Game.repository;

import Game.Game.Dto.UserInfoDto;
import Game.Game.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    void save(User user);

    User findByNickname(String nickname);

    Optional<User> findById(Long id);

    List<UserInfoDto> selectAll(String name);

    void hunt(Long id, Long level, Long experience);
}