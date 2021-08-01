package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.BranchDto;
import education.io.educationapi.Dtos.OrganizationDto;
import education.io.educationapi.domain.interfaces.org.IBranchDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/arg/{orgId}/branches")
public class BranchController {
    private IBranchDomainService _iBranchDomainService;

    public BranchController(IBranchDomainService iBranchDomainService) {
        this._iBranchDomainService = iBranchDomainService;
    }

    @GetMapping("")
    public ResponseEntity<List<OrganizationDto>> GetAll(@PathVariable int orgId) {

        return new ResponseEntity( _iBranchDomainService.getAll(orgId), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<OrganizationDto> getById(@PathVariable int orgId,@PathVariable int id) {

        return  new ResponseEntity(_iBranchDomainService.getById(orgId,id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<OrganizationDto> create(@PathVariable int orgId ,@Valid @RequestBody BranchDto branchDto) {

        return   new ResponseEntity( _iBranchDomainService.create(orgId,branchDto),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<OrganizationDto> update(@PathVariable int orgId , @PathVariable int id,@Valid  @RequestBody BranchDto branchDto) {
        branchDto.setId(id);

        return  new ResponseEntity( _iBranchDomainService.update(orgId,branchDto),HttpStatus.OK);
    }
}
