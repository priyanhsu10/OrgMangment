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
import java.util.concurrent.CompletableFuture;

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
    public CompletableFuture< List<BranchDto>> getAll(int orgId) {
       return CompletableFuture.supplyAsync(()->branchRepository.findByOrganizationId(orgId))
                .thenApply(e->mapper.toBranchDto(e));
    }

    @Override
    public CompletableFuture< BranchDto> getById(int orgId, int id) {

    return     CompletableFuture.supplyAsync(()-> branchRepository.findById(id).orElseThrow(() -> new RuntimeException("BranchNotFound")))
                .thenApply(x->  mapper.toBranchDto(x));

    }

    @Override
    public CompletableFuture< BranchDto> create(int orgId, BranchDto branchDto) {
      return CompletableFuture.supplyAsync(()->organizationRepository.findById(orgId).orElseThrow(() -> new RuntimeException("OrganizationNotFound")))
               .thenApply(org-> this.createBranch(branchDto,org))
               .thenApply(b-> mapper.toBranchDto(b));

    }
  private  Branch createBranch(BranchDto branchDto, Organization organization){
      Branch b = mapper.toBranch(branchDto);
      b.setOrganization(organization);
      return branchRepository.save(b);
  }
  private  Branch updateBranch(Branch branch,BranchDto branchDto) {
      branch.setDescription(branchDto.getDescription());
      branch.setName(branchDto.getName());
     return branchRepository.save(branch);
  }
    @Override
    public CompletableFuture< BranchDto> update(int orgId, BranchDto branchDto) {
        return  CompletableFuture.supplyAsync(()->branchRepository.findByIdAndOrganizationId(branchDto.getId(),orgId).orElseThrow(() -> new RuntimeException("BranchNotFound")))
                .thenApply(branch->updateBranch(branch,branchDto))
                .thenApply(branch->mapper.toBranchDto(branch));

    }
}
