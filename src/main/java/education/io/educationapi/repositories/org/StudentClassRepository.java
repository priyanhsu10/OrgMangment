package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Students;
import education.io.educationapi.entities.org.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends CrudRepository<Students, Integer> {
}
