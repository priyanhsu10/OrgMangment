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

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private IOrganizationDomainService organizationDomainService;

    public OrganizationController(IOrganizationDomainService iOrganizationDomainService) {
        organizationDomainService = iOrganizationDomainService;
    }

    @GetMapping("")
    public ResponseEntity<List<OrganizationDto>>GetAll() {

        return new ResponseEntity( organizationDomainService.getAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<OrganizationDto> getById(@PathVariable int id) {

        return  new ResponseEntity(organizationDomainService.getById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<OrganizationDto> create(@Valid @RequestBody OrganizationDto organizationDto) {

        return   new ResponseEntity( organizationDomainService.create(organizationDto),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<OrganizationDto> update( @PathVariable int id,@Valid  @RequestBody OrganizationDto organizationDto) {
       // organizationDto.setId(id);
        return  new ResponseEntity( organizationDomainService.update(organizationDto),HttpStatus.OK);
    }
}

