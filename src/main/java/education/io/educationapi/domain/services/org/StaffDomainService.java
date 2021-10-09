package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.StaffDto;
import education.io.educationapi.domain.interfaces.org.IStaffDomainService;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.StaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class StaffDomainService implements IStaffDomainService {
    private final StaffRepository staffRepository;
    private final IMapper mapper;

    public StaffDomainService(StaffRepository staffRepository, IMapper mapper) {
        this.staffRepository = staffRepository;
        this.mapper = mapper;
    }

    @Override
    public CompletableFuture<List<StaffDto>> getByOrganizationId(int orgId) {
        return  CompletableFuture.supplyAsync(()->staffRepository.findByOrganizationId(orgId))
                .thenApply(x->x.stream().map(y->mapper.staffToStaffDto(y)).collect(Collectors.toList()));

    }

    @Override
    public CompletableFuture<List<StaffDto>> getByDepartmentId(int departmentId) {
       return  CompletableFuture.supplyAsync(()->staffRepository.findByDepartmentId(departmentId))
                .thenApply(x->x.stream().map(y->mapper.staffToStaffDto(y)).collect(Collectors.toList()));
    }

    @Override
    public CompletableFuture<Page<StaffDto>> getAll(PageRequest p) {

        return CompletableFuture.supplyAsync(() -> staffRepository.findAll(p))
                .thenApply(x -> x.map(std->mapper.staffToStaffDto(std)));
    }

    @Override
    public CompletableFuture<StaffDto> update(StaffDto staffDto) {
        return null;
    }

    @Override
    public CompletableFuture<StaffDto> create(StaffDto staffDto) {
        return null;
    }
}
