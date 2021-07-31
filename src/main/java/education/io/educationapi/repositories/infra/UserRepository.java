package education.io.educationapi.repositories.infra;

import education.io.educationapi.entities.infra.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
