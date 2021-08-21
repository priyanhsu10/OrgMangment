package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.BranchDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IBranchDomainService {
    CompletableFuture<List<BranchDto>> getAll(int orgid);

    CompletableFuture< BranchDto> getById(int orgid, int id);

    CompletableFuture< BranchDto> create(int orgId,BranchDto branchDto);

    CompletableFuture< BranchDto> update(int orgId, BranchDto branchDto);
}
