package Game.Game.repository;

import Game.Game.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void save(User user);

    User findByNickName(String nickName);
}