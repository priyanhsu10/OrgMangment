package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.StandardsClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardClassRepository extends CrudRepository<StandardsClass, Integer> {
}
