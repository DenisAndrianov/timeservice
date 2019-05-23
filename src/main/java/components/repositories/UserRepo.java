package components.repositories;

import components.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByLoginAndPass(String login, String pass);

    Optional<User> findById(Integer id);
}
