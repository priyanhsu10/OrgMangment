package education.io.educationapi.repositories.infra;

import education.io.educationapi.entities.infra.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
