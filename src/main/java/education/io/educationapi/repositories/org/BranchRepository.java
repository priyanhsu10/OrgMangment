package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Integer> {
}
