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
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class DepartmentDomainService implements IDepartmentDomainService {


    private final BranchRepository branchRepository;
    private final IMapper mapper;
    private final OrganizationRepository organizationRepository;
    private final DepartmentRepository departmentRepository;

    public DepartmentDomainService(DepartmentRepository departmentRepository, BranchRepository branchRepository, IMapper mapper,
                                   OrganizationRepository organizationRepository) {
        this.branchRepository = branchRepository;
        this.mapper = mapper;
        this.organizationRepository = organizationRepository;
        this.departmentRepository = departmentRepository;
    }

    private static RuntimeException getDepartmentBYId() {
        return new RuntimeException("DepartmentNotFound");
    }

    @Override
    public CompletableFuture<List<DepartmentDto>> getAll(int orgId, int branchId) {
        return CompletableFuture.supplyAsync(() -> departmentRepository.findAllByBranchIdAndOrganizationId(orgId, branchId))
                .thenApply(d -> mapper.departmentToDepartmentDto(d));
    }

    @Override
    public CompletableFuture<DepartmentDto> getById(int orgId, int branchId, int id) {
       return CompletableFuture.supplyAsync(() -> departmentRepository.findById(id).orElseThrow(DepartmentDomainService::getDepartmentBYId))
                .thenApply(d -> mapper.departmentToDepartmentDto(d));
    }

    @Override
    public CompletableFuture<DepartmentDto> create(int orgId, int branchId, DepartmentDto departmentDto) {
        return CompletableFuture.supplyAsync(() -> organizationRepository.findById(orgId).orElseThrow(() -> new RuntimeException("OrganizationNotFound")))
                .thenApply(org -> getPair(org, branchId))
                .thenApply(x -> saveDepartment(departmentDto, x))
                .thenApply(d -> mapper.departmentToDepartmentDto(d));

    }

    private Department saveDepartment(DepartmentDto departmentDto, Pair<Organization, Branch> x) {
        Department department = mapper.toDepartment(departmentDto);
        department.setBranch(x.getRight());
        department.setOrganization(x.getLeft());
        return departmentRepository.save(department);
    }

    private Pair<Organization, Branch> getPair(Organization org, int branchId) {
        Branch b = branchRepository.findById(branchId).orElseThrow(() -> new RuntimeException("BranchNotFound"));
        return Pair.of(org, b);


    }

    @Override
    public CompletableFuture<DepartmentDto> update(int orgId, int branchId, int id, DepartmentDto branchDto) {
        return CompletableFuture.supplyAsync(validateBranchExist(branchId))
                .thenRun(validateOrgExist(orgId))
                .thenApply(getBranch(branchId))
                .thenApply(updateDepartment(branchDto))
                .thenApply(d -> mapper.departmentToDepartmentDto(d));

    }

    private Function<Void, Department> getBranch(int branchId) {
        return (c) -> departmentRepository.findById(branchId).orElseThrow(() -> new RuntimeException("BranchNotFound"));
    }

    private Supplier<Boolean> validateBranchExist(int branchId) {
        return () -> {
            if (!branchRepository.existsById(branchId)) throw new RuntimeException("BranchNotFound");
            return true;
        };
    }

    private Runnable validateOrgExist(int orgId) {
        return () -> {
            if (!organizationRepository.existsById(orgId)) throw new RuntimeException("OrganizationNotFound");
        };
    }

    private Function<Department, Department> updateDepartment(DepartmentDto branchDto) {
        return department -> {
            department.setName(branchDto.getName());
            department.setDescription(branchDto.getDescription());
            return departmentRepository.save(department);
        };
    }
}
