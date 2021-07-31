package education.io.educationapi.repositories.infra;

import education.io.educationapi.entities.infra.RolePermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository  extends CrudRepository<RolePermission,Integer> {
}
