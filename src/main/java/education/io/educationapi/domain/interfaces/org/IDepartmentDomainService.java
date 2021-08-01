package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDepartmentDomainService {
    List<DepartmentDto> getAll(int orgId, int branchId);

    DepartmentDto getById(int orgId, int branchId, int id);

    DepartmentDto create(int orgId, int branchId, DepartmentDto branchDto);

    DepartmentDto update(int orgId, int branchId, int id, DepartmentDto branchDto);
}
