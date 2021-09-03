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
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/subjects")

public class SubjectController {
    private ISubjectDomainService _iSubjectDomainService;
    public SubjectController(ISubjectDomainService subjectDomainService) {
        this._iSubjectDomainService = subjectDomainService;
    }

    @GetMapping("")
    public CompletableFuture< ResponseEntity<List<SubjectDto>> >GetAll() {
       return  _iSubjectDomainService.getAll().thenApply(ResponseEntity::ok);
    }
    @GetMapping(path = "/{id}")
    public CompletableFuture< ResponseEntity<SubjectDto>> getById(@PathVariable int id) {
        return  _iSubjectDomainService.getById(id).thenApply(ResponseEntity::ok);
    }
    @PostMapping("")
    public CompletableFuture<ResponseEntity<SubjectDto>> create(@Valid @RequestBody SubjectDto subjectDto) {
        return  _iSubjectDomainService.create(subjectDto).thenApply(ResponseEntity::ok);

    }
    @PutMapping("/{id}")
    public  CompletableFuture<ResponseEntity<SubjectDto>> update( @PathVariable int id,@Valid  @RequestBody SubjectDto subjectDto) {
        subjectDto.setId(id);
        return  _iSubjectDomainService.update(id,subjectDto).thenApply(ResponseEntity::ok);
    }



}
