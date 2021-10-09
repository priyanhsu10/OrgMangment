package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    List<Staff> findByOrganizationId(int orgId);

    List<Staff> findByDepartmentId(int departmentId);
}
