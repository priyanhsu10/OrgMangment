package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.DepartmentDto;
import education.io.educationapi.Dtos.OrganizationDto;
import education.io.educationapi.domain.interfaces.org.IOrganizationDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private IOrganizationDomainService organizationDomainService;

    public OrganizationController(IOrganizationDomainService iOrganizationDomainService) {
        organizationDomainService = iOrganizationDomainService;
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity<List<OrganizationDto>>> GetAll() {

        return organizationDomainService.getAll().thenApply((x)->new ResponseEntity(x , HttpStatus.OK));
    }
    @GetMapping(path = "/{id}")
    public CompletableFuture<ResponseEntity<OrganizationDto>> getById(@PathVariable int id) {

        return  organizationDomainService.getById(id).thenApply(x-> new ResponseEntity(x, HttpStatus.OK));
    }
    @PostMapping("")
    public CompletableFuture<ResponseEntity<OrganizationDto>> create(@Valid @RequestBody OrganizationDto organizationDto) {
        return  organizationDomainService.create(organizationDto).thenApply(x-> new ResponseEntity(x, HttpStatus.CREATED));
    }
    @PutMapping("/{id}")
    public  CompletableFuture<ResponseEntity<OrganizationDto>> update( @PathVariable int id,@Valid  @RequestBody OrganizationDto organizationDto) {
       organizationDto.setId(id);
        return  organizationDomainService.update(organizationDto).thenApply(x-> new ResponseEntity(x, HttpStatus.OK));
    }
}

