package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.OrganizationDto;
import education.io.educationapi.Dtos.StandardDto;
import education.io.educationapi.Dtos.SubjectDto;
import education.io.educationapi.domain.interfaces.org.IStandardDomainService;
import education.io.educationapi.domain.interfaces.org.ISubjectDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/standards")

public class StandardController {
    private IStandardDomainService _iStandardDomainService;
    public StandardController(IStandardDomainService subjectDomainService) {
        this._iStandardDomainService = subjectDomainService;
    }

    @GetMapping("")
    public ResponseEntity<List<StandardDto>> GetAll() {

        return new ResponseEntity( _iStandardDomainService.getAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<StandardDto> getById(@PathVariable int id) {

        return  new ResponseEntity(_iStandardDomainService.getById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<StandardDto> create(@Valid @RequestBody StandardDto standardDto) {

        return   new ResponseEntity( _iStandardDomainService.create(standardDto),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<StandardDto> update( @PathVariable int id,@Valid  @RequestBody StandardDto standardDto) {
        standardDto.setId(id);
        return  new ResponseEntity( _iStandardDomainService.update(id,standardDto),HttpStatus.OK);
    }

}
