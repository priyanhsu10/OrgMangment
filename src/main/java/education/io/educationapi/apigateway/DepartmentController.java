package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.BranchDto;
import education.io.educationapi.Dtos.DepartmentDto;
import education.io.educationapi.Dtos.OrganizationDto;
import education.io.educationapi.domain.interfaces.org.IBranchDomainService;
import education.io.educationapi.domain.interfaces.org.IDepartmentDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/arg/{orgId}/branches/{branchId}/departments")

public class DepartmentController {
    private IDepartmentDomainService _IDepartmentDomainService;

    public DepartmentController(IDepartmentDomainService iDepartmentDomainService) {
        this._IDepartmentDomainService = iDepartmentDomainService;
    }

    @GetMapping("")
    public ResponseEntity<List<OrganizationDto>> GetAll(@PathVariable int orgId,@PathVariable int branchId) {

        return new ResponseEntity( _IDepartmentDomainService.getAll(orgId,branchId), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<OrganizationDto> getById(@PathVariable int orgId,@PathVariable int branchId,@PathVariable int id) {

        return  new ResponseEntity(_IDepartmentDomainService.getById(orgId,branchId,id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<OrganizationDto> create(@PathVariable int orgId ,@PathVariable int branchId,@Valid @RequestBody DepartmentDto branchDto) {

        return   new ResponseEntity( _IDepartmentDomainService.create(orgId,branchId,branchDto),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<OrganizationDto> update(@PathVariable int orgId ,@PathVariable int branchId, @PathVariable int id,@Valid  @RequestBody DepartmentDto branchDto) {
        branchDto.setId(id);

        return  new ResponseEntity( _IDepartmentDomainService.update(orgId,branchId,id,branchDto),HttpStatus.OK);
    }
}
