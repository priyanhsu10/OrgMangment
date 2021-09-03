package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.DepartmentDto;
import education.io.educationapi.domain.interfaces.org.IDepartmentDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/arg/{orgId}/branches/{branchId}/departments")

public class DepartmentController {
    private IDepartmentDomainService _IDepartmentDomainService;

    public DepartmentController(IDepartmentDomainService iDepartmentDomainService) {
        this._IDepartmentDomainService = iDepartmentDomainService;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<DepartmentDto>>> GetAll(@PathVariable int orgId, @PathVariable int branchId) {

        return _IDepartmentDomainService.getAll(orgId,branchId).thenApply(x-> new ResponseEntity( x, HttpStatus.OK));
    }
    @GetMapping(path = "/{id}")
    public CompletableFuture<ResponseEntity<DepartmentDto>> getById(@PathVariable int orgId,@PathVariable int branchId,@PathVariable int id) {

        return   _IDepartmentDomainService.getById(orgId,branchId,id).thenApply(x->new ResponseEntity(x, HttpStatus.OK));
    }
    @PostMapping
    public CompletableFuture<ResponseEntity<DepartmentDto>> create(@PathVariable int orgId ,@PathVariable int branchId,@Valid @RequestBody DepartmentDto departmentDto) {

        return   _IDepartmentDomainService.create(orgId,branchId,departmentDto).thenApply(x-> new ResponseEntity(x,HttpStatus.CREATED));
    }
    @PutMapping("/{id}")
    public   CompletableFuture<ResponseEntity<DepartmentDto>> update(@PathVariable int orgId ,@PathVariable int branchId, @PathVariable int id,@Valid  @RequestBody DepartmentDto departmentDto) {
        departmentDto.setId(id);


        return _IDepartmentDomainService.update(orgId,branchId,id,departmentDto).thenApply(x-> new ResponseEntity( x,HttpStatus.OK));
    }
}
