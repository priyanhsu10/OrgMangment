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
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/standards/{standardId}/classes")

public class StandardClassController {
    private IStandardClassDomainService _iStandardClassDomainService;

    public StandardClassController(IStandardClassDomainService iStandardClassDomainService
    ) {
        _iStandardClassDomainService = iStandardClassDomainService;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<StandardsClassDto>>> GetAll(@PathVariable int standardId ) {

        return  _iStandardClassDomainService.getAll(standardId).thenApply(x-> new ResponseEntity(x, HttpStatus.OK));
    }
    @GetMapping(path = "/{id}")
    public CompletableFuture<ResponseEntity<ResponseEntity<StandardsClassDto>>> getById( @PathVariable int standardId,@PathVariable int id) {
        return  _iStandardClassDomainService.getById(standardId,id).thenApply(x-> new ResponseEntity(x, HttpStatus.OK));
    }
    @PostMapping
    public CompletableFuture<ResponseEntity<ResponseEntity<StandardsClassDto>>> create(@Valid @RequestBody StandardsClassDto standardDto,@PathVariable int standardId) {

        return  _iStandardClassDomainService.create(standardId,standardDto).thenApply(x-> new ResponseEntity(x, HttpStatus.CREATED));
    }
    @PutMapping("/{id}")
    public  CompletableFuture<ResponseEntity<ResponseEntity<StandardsClassDto>>> update(@PathVariable int standardId, @PathVariable int id,@Valid  @RequestBody StandardsClassDto standardDto) {
        standardDto.setId(id);
        return  _iStandardClassDomainService.update(id,standardId,standardDto).thenApply(x-> new ResponseEntity(x, HttpStatus.CREATED));
    }
}
