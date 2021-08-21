package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.OrganizationDto;
import education.io.educationapi.domain.interfaces.org.IOrganizationDomainService;
import education.io.educationapi.entities.org.Organization;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.OrganizationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class OrganizationDomainService implements IOrganizationDomainService {
    private final OrganizationRepository organizationRepository;
    private final IMapper iMapper;

    public OrganizationDomainService(OrganizationRepository organizationRepository, IMapper iMapper) {
        this.organizationRepository = organizationRepository;
        this.iMapper = iMapper;
    }

    @Override
    public CompletableFuture<List<OrganizationDto>> getAll() {
        return CompletableFuture.supplyAsync(() -> this.organizationRepository.findAll()).
                thenApply(data -> iMapper.organizationToOrganizationDto(data));
    }

    @Override
    public CompletableFuture<OrganizationDto> getById(Integer id) {
        return CompletableFuture
                .supplyAsync(() -> organizationRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Organization not found")))
                .thenApply(org -> iMapper.organizationToOrganizationDto(org));

    }

    @Override
    public CompletableFuture<OrganizationDto> create(OrganizationDto organizationDto) {
        Organization org = iMapper.organizationDtoToOrganization(organizationDto);
        return   CompletableFuture.supplyAsync(()->this.organizationRepository.save(org))
                .thenApply(o->iMapper.organizationToOrganizationDto(o));
    }



    @Override
    public CompletableFuture<OrganizationDto> update(OrganizationDto organizationDto) {
        Organization org = iMapper.organizationDtoToOrganization(organizationDto);
       return CompletableFuture.supplyAsync(()->organizationRepository.findById(organizationDto.getId()).orElseThrow( ()->new RuntimeException("Organization not found")))
               .thenApply(x->updateOrg(organizationDto, x))
               .thenApply(x->iMapper.organizationToOrganizationDto(x));
    }

    private Organization updateOrg(OrganizationDto organizationDto, Organization x) {
        x.setName(organizationDto.getName());
        x.setDescription(organizationDto.getDescription());
        x.setAddress(organizationDto.getAddress());
        return    organizationRepository.save(x);
    }
}
