package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.StandardDto;
import education.io.educationapi.domain.interfaces.org.IStandardDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/standards")

public class StandardController {
    private IStandardDomainService _iStandardDomainService;
    public StandardController(IStandardDomainService subjectDomainService) {
        this._iStandardDomainService = subjectDomainService;
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity<List<StandardDto>>> GetAll() {

        return  _iStandardDomainService.getAll().thenApply(ResponseEntity::ok);
    }
    @GetMapping(path = "/{id}")
    public CompletableFuture<ResponseEntity<StandardDto>> getById(@PathVariable int id) {
        return  _iStandardDomainService.getById(id).thenApply(ResponseEntity::ok);
    }
    @PostMapping("")
    public CompletableFuture<ResponseEntity<StandardDto>> create(@Validated @RequestBody StandardDto standardDto) {
        return  _iStandardDomainService.create(standardDto).thenApply(ResponseEntity::ok);
    }
    @PutMapping("/{id}")
    public  CompletableFuture<ResponseEntity<StandardDto>> update( @PathVariable int id,@Validated @RequestBody StandardDto standardDto) {
        standardDto.setId(id);
        return  _iStandardDomainService.update(id,standardDto).thenApply(ResponseEntity::ok);
    }
   @PutMapping("{id}/addSubject")
    public CompletableFuture<ResponseEntity<StandardDto>> addSubjects( @PathVariable int id, @RequestBody List<Integer> subjectIds){
       return  _iStandardDomainService.addSubjects(id,subjectIds).thenApply(ResponseEntity::ok);

   }
}
