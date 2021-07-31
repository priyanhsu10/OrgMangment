package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Standard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardRepository extends CrudRepository<Standard, Integer> {
}
