package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Department;
import education.io.educationapi.entities.org.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
