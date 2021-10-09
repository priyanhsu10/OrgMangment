package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.StaffDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface IStaffDomainService {
    CompletableFuture<List<StaffDto>> getByOrganizationId(int orgId);

    CompletableFuture<List<StaffDto>> getByDepartmentId(int departmentId);

    CompletableFuture<Page<StaffDto>> getAll(PageRequest p);

    CompletableFuture<StaffDto> update(StaffDto staffDto);

    CompletableFuture<StaffDto> create(StaffDto staffDto);
}
