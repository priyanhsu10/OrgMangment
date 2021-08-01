package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.DepartmentDto;
import education.io.educationapi.domain.interfaces.org.IDepartmentDomainService;
import education.io.educationapi.entities.org.Branch;
import education.io.educationapi.entities.org.Department;
import education.io.educationapi.entities.org.Organization;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.BranchRepository;
import education.io.educationapi.repositories.org.DepartmentRepository;
import education.io.educationapi.repositories.org.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentDomainService implements IDepartmentDomainService {


    private final BranchRepository branchRepository;
    private final IMapper mapper;
    private final OrganizationRepository organizationRepository;
    private final DepartmentRepository departmentRepository;
    public DepartmentDomainService(DepartmentRepository departmentRepository,BranchRepository branchRepository, IMapper mapper,
                                   OrganizationRepository organizationRepository) {
        this.branchRepository = branchRepository;
        this.mapper = mapper;
        this.organizationRepository = organizationRepository;
        this.departmentRepository=departmentRepository;
    }
    @Override
    public List<DepartmentDto> getAll(int orgId, int branchId) {
        return mapper.departmentToDepartmentDto(departmentRepository.FindByBranchIdAndOrganizationId(orgId,branchId));
    }

    @Override
    public DepartmentDto getById(int orgId, int branchId, int id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("DepartmentNotFound"));
        return mapper.departmentToDepartmentDto(department);
    }

    @Override
    public DepartmentDto create(int orgId, int branchId, DepartmentDto departmentDto) {
        Organization org = organizationRepository.findById(orgId).orElseThrow(() -> new RuntimeException("OrganizationNotFound"));
        Branch branch = branchRepository.findById(branchId).orElseThrow(() -> new RuntimeException("BranchNotFound"));
        Department department = mapper.toDepartment(departmentDto);
        department.setBranch(branch);
        department.setOrganization(org);

        return mapper.departmentToDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto update(int orgId, int branchId, int id, DepartmentDto branchDto) {
      if( !branchRepository.existsById(branchId))throw new RuntimeException("BranchNotFound");
      if( !organizationRepository.existsById(orgId))throw new RuntimeException("OrganizationNotFound");

        Department department = departmentRepository.findById(branchId).orElseThrow(() -> new RuntimeException("BranchNotFound"));
        department.setName(branchDto.getName());
        department.setDescription(branchDto.getDescription());

        return mapper.departmentToDepartmentDto(departmentRepository.save(department));
    }
}
