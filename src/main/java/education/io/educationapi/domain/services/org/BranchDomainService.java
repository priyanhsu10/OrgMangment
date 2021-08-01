package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.BranchDto;
import education.io.educationapi.domain.interfaces.org.IBranchDomainService;
import education.io.educationapi.domain.interfaces.org.IOrganizationDomainService;
import education.io.educationapi.entities.org.Branch;
import education.io.educationapi.entities.org.Organization;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.BranchRepository;
import education.io.educationapi.repositories.org.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchDomainService implements IBranchDomainService {
    private final BranchRepository branchRepository;
    private final IMapper mapper;
    private final OrganizationRepository organizationRepository;

    public BranchDomainService(BranchRepository branchRepository, IMapper mapper, OrganizationRepository organizationRepository) {
        this.branchRepository = branchRepository;
        this.mapper = mapper;
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<BranchDto> getAll(int orgId) {
        return mapper.toBranchDto(branchRepository.findByOrganizationId(orgId));
    }

    @Override
    public BranchDto getById(int orgId, int id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("BranchNotFound"));
        return mapper.toBranchDto(branch);
    }

    @Override
    public BranchDto create(int orgId, BranchDto branchDto) {

        Organization org = organizationRepository.findById(orgId).orElseThrow(() -> new RuntimeException("OrganizationNotFound"));
        Branch b = mapper.toBranch(branchDto);
        b.setOrganization(org);
        return mapper.toBranchDto(branchRepository.save(b));
    }

    @Override
    public BranchDto update(int orgId, BranchDto branchDto) {
        Organization org = organizationRepository.findById(orgId).orElseThrow(() -> new RuntimeException("OrganizationNotFound"));
        Branch b = mapper.toBranch(branchDto);
        b.setOrganization(org);
        return mapper.toBranchDto(branchRepository.save(b));
    }
}
