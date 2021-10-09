package education.io.educationapi.repositories.org;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import education.io.educationapi.entities.org.Standard;

@Repository
public interface StandardRepository extends JpaRepository<Standard, Integer> {
}
