package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.OrganizationDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrganizationDomainService {
    List<OrganizationDto> getAll();
    OrganizationDto getById(Integer Id);
    OrganizationDto create(OrganizationDto organizationDto);
    OrganizationDto update(OrganizationDto organizationDto);

}
