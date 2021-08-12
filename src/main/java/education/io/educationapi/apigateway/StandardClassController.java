package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.StandardDto;
import education.io.educationapi.Dtos.StandardsClassDto;
import education.io.educationapi.Dtos.SubjectDto;
import education.io.educationapi.domain.interfaces.org.IStandardClassDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/standards/{standardId}/classes")

public class StandardClassController {
    private IStandardClassDomainService _iStandardClassDomainService;

    public StandardClassController(IStandardClassDomainService iStandardClassDomainService
    ) {
        _iStandardClassDomainService = iStandardClassDomainService;
    }

    @GetMapping("/")
    public ResponseEntity<List<StandardsClassDto>> GetAll(@PathVariable int standardId ) {

        return new ResponseEntity( _iStandardClassDomainService.getAll(standardId), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<StandardsClassDto> getById( @PathVariable int standardId,@PathVariable int id) {

        return  new ResponseEntity(_iStandardClassDomainService.getById(standardId,id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<StandardsClassDto> create(@Valid @RequestBody StandardsClassDto standardDto,@PathVariable int standardId) {

        return   new ResponseEntity( _iStandardClassDomainService.create(standardId,standardDto),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<StandardsClassDto> update(@PathVariable int standardId, @PathVariable int id,@Valid  @RequestBody StandardsClassDto standardDto) {
        standardDto.setId(id);
        return  new ResponseEntity( _iStandardClassDomainService.update(id,standardId,standardDto),HttpStatus.OK);
    }
}
