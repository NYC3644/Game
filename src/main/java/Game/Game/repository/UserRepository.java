package Game.Game.repository;

import Game.Game.domain.User;


public interface UserRepository {

    void save(User user);

    User findById(Long user);
}
