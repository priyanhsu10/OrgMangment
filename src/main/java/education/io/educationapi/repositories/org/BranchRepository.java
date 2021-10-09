package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    List<Branch> findByOrganizationId(int OrgId);

    Optional<Branch> findByIdAndOrganizationId(int id, int orgId);
}
