package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffClassRepository extends JpaRepository<Staff, Integer> {
}
