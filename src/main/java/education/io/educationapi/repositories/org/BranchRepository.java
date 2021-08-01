package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Integer> {
    List<Branch> findByOrganizationId(int OrgId);
}
