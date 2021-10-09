package education.io.educationapi.repositories.org;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import education.io.educationapi.entities.org.StandardsClass;

@Repository
public interface StandardClassRepository extends JpaRepository<StandardsClass, Integer> {
    Optional<StandardsClass> findByStandardIdAndId(int standardId, int id);

    List<StandardsClass> findByStandardId(int standardId);
}
