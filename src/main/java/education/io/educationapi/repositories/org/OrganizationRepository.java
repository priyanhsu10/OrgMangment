package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization,Integer> {
}
