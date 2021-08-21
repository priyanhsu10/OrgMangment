package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findAllByBranchIdAndOrganizationId(int branchId, int organizationId);
}
