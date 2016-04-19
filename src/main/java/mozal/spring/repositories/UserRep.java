package mozal.spring.repositories;

import mozal.spring.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Monika on 2016-04-11.
 */
public interface UserRep extends CrudRepository<User, Long> {
    User findByEmail(String email);

}
