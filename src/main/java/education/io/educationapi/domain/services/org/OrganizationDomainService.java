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
@Service
public class OrganizationDomainService implements IOrganizationDomainService {
    private final OrganizationRepository organizationRepository;
    private final  IMapper iMapper;

    public OrganizationDomainService(OrganizationRepository organizationRepository, IMapper iMapper) {
        this.organizationRepository = organizationRepository;
        this.iMapper = iMapper;
    }

    @Override
    public List<OrganizationDto> getAll() {
       Iterable<Organization> data=this.organizationRepository.findAll();
       return iMapper.organizationToOrganizationDto(data);
    }

    @Override
    public OrganizationDto getById(Integer id) {
       Organization data= this.organizationRepository.findById(id).orElseThrow(()->new RuntimeException("Organization not found"));
        return  iMapper.organizationToOrganizationDto(data);
    }

    @Override
    public OrganizationDto create(OrganizationDto organizationDto) {
        Organization org= iMapper.organizationDtoToOrganization(organizationDto);
        return iMapper.organizationToOrganizationDto( this.organizationRepository.save(org));
    }

    @Override
    public OrganizationDto update(OrganizationDto organizationDto) {
        Organization org= iMapper.organizationDtoToOrganization(organizationDto);
      return   iMapper.organizationToOrganizationDto( this.organizationRepository.save(org));
    }
}
