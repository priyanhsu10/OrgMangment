package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.OrganizationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IOrganizationDomainService {
    CompletableFuture<List<OrganizationDto>> getAll();

    CompletableFuture<OrganizationDto> getById(Integer Id);

    CompletableFuture<OrganizationDto> create(OrganizationDto organizationDto);

    CompletableFuture<OrganizationDto> update(OrganizationDto organizationDto);

}
