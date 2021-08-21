package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface IDepartmentDomainService {
   CompletableFuture< List<DepartmentDto>> getAll(int orgId, int branchId);

    CompletableFuture< DepartmentDto> getById(int orgId, int branchId, int id);

    CompletableFuture<DepartmentDto> create(int orgId, int branchId, DepartmentDto branchDto);

    CompletableFuture<DepartmentDto> update(int orgId, int branchId, int id, DepartmentDto branchDto);
}
