package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.BranchDto;

import java.util.List;

public interface IBranchDomainService {
    List<BranchDto> getAll(int orgid);

    BranchDto getById(int orgid, int id);

    BranchDto create(int orgId,BranchDto branchDto);

    BranchDto update(int orgId, BranchDto branchDto);
}
