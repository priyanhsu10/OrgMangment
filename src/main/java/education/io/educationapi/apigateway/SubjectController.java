package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.BranchDto;
import education.io.educationapi.Dtos.OrganizationDto;
import education.io.educationapi.Dtos.SubjectDto;
import education.io.educationapi.domain.interfaces.org.IBranchDomainService;
import education.io.educationapi.domain.interfaces.org.ISubjectDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/subjects")

public class SubjectController {
    private ISubjectDomainService _iSubjectDomainService;
    public SubjectController(ISubjectDomainService subjectDomainService) {
        this._iSubjectDomainService = subjectDomainService;
    }

    @GetMapping("")
    public ResponseEntity<List<OrganizationDto>> GetAll() {

        return new ResponseEntity( _iSubjectDomainService.getAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<SubjectDto> getById(@PathVariable int id) {

        return  new ResponseEntity(_iSubjectDomainService.getById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<SubjectDto> create(@Valid @RequestBody SubjectDto subjectDto) {

        return   new ResponseEntity( _iSubjectDomainService.create(subjectDto),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<SubjectDto> update( @PathVariable int id,@Valid  @RequestBody SubjectDto subjectDto) {
        subjectDto.setId(id);
        return  new ResponseEntity( _iSubjectDomainService.update(id,subjectDto),HttpStatus.OK);
    }
}
