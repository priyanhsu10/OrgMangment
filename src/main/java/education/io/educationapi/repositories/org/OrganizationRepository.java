package education.io.educationapi.repositories.org;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import education.io.educationapi.entities.org.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
