package Repository;

import Entity.User;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findByLoginOrEmail(String username, String username1);

    User save(User user);
}

