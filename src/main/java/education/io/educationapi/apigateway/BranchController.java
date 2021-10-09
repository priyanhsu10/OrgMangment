package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.BranchDto;
import education.io.educationapi.Dtos.OrganizationDto;
import education.io.educationapi.domain.interfaces.org.IBranchDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/arg/{orgId}/branches")
public class BranchController {
    private IBranchDomainService _iBranchDomainService;

    public BranchController(IBranchDomainService iBranchDomainService) {
        this._iBranchDomainService = iBranchDomainService;
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity<List<OrganizationDto>>> GetAll(@PathVariable int orgId) {

        return _iBranchDomainService.getAll(orgId).thenApply(x -> new ResponseEntity(x, HttpStatus.OK));
    }

    @GetMapping(path = "/{id}")
    public CompletableFuture<ResponseEntity<OrganizationDto>> getById(@PathVariable int orgId, @PathVariable int id) {

        return _iBranchDomainService.getById(orgId, id).thenApply(x -> new ResponseEntity(x, HttpStatus.OK));
    }

    @PostMapping("")
    public CompletableFuture<ResponseEntity<OrganizationDto>> create(@PathVariable int orgId,
            @Valid @RequestBody BranchDto branchDto) {

        return _iBranchDomainService.create(orgId, branchDto).thenApply(x -> new ResponseEntity(x, HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<OrganizationDto>> update(@PathVariable int orgId, @PathVariable int id,
            @Valid @RequestBody BranchDto branchDto) {
        branchDto.setId(id);
        return _iBranchDomainService.update(orgId, branchDto).thenApply(x -> new ResponseEntity(x, HttpStatus.OK));
    }
}
