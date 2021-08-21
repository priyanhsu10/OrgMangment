package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.StandardsClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StandardClassRepository extends JpaRepository<StandardsClass, Integer> {
    Optional<StandardsClass> findByStandardIdAndId(int standardId, int id);
    List<StandardsClass> findByStandardId(int standardId);
}
